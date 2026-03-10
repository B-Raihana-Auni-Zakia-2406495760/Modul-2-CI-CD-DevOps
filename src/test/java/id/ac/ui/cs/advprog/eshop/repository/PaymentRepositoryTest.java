package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {
    PaymentRepository paymentRepository;
    Payment payment1;
    Payment payment2;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();

        java.util.List<Product> products = new java.util.ArrayList<>();
        Product dummy = new Product();
        dummy.setProductId("prod1");
        dummy.setProductName("kecap");
        dummy.setProductQuantity(1);
        products.add(dummy);

        Order order = new Order("order1", products, 123L, "laffar");

        Map<String, String> data1 = new HashMap<>();
        data1.put("voucherCode", "ESHOPABC12345678");
        payment1 = new Payment("pay1", "VOUCHER", data1, order);

        Map<String, String> data2 = new HashMap<>();
        data2.put("bankName", "ABC");
        data2.put("referenceCode", "REF123");
        payment2 = new Payment("pay2", "BANK", data2, order);
    }

    @Test
    void testSaveCreate() {
        Payment result = paymentRepository.save(payment1);
        Payment findResult = paymentRepository.findById(payment1.getId());
        assertEquals(payment1.getId(), result.getId());
        assertEquals(payment1.getId(), findResult.getId());
    }

    @Test
    void testSaveUpdate() {
        paymentRepository.save(payment1);
        payment1.setStatus("SUCCESS");
        Payment result = paymentRepository.save(payment1);
        Payment findResult = paymentRepository.findById(payment1.getId());
        assertEquals(payment1.getId(), result.getId());
        assertEquals("SUCCESS", findResult.getStatus());
    }

    @Test
    void testFindByIdIfFound() {
        paymentRepository.save(payment1);
        Payment findResult = paymentRepository.findById(payment1.getId());
        assertEquals(payment1.getId(), findResult.getId());
    }

    @Test
    void testFindByIdIfNotFound() {
        paymentRepository.save(payment1);
        assertNull(paymentRepository.findById("invalid-id"));
    }

    @Test
    void testGetAllPayments() {
        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
        List<Payment> paymentList = paymentRepository.getAllPayments();
        assertEquals(2, paymentList.size());
    }
}