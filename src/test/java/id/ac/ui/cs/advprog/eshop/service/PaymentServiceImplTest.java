package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {
    @InjectMocks
    PaymentServiceImpl paymentService;

    @Mock
    PaymentRepository paymentRepository;

    @Mock
    OrderService orderService;

    Order order;
    Payment payment;

    @BeforeEach
    void setUp() {
        java.util.List<Product> products = new java.util.ArrayList<>();
        Product dummy = new Product();
        dummy.setProductId("prod1");
        dummy.setProductName("kecap");
        dummy.setProductQuantity(1);
        products.add(dummy);

        order = new Order("order1", products, 123L, "laffar");

        Map<String, String> data = new HashMap<>();
        data.put("voucherCode", "ESHOPABC12345678");
        payment = new Payment("pay1", "VOUCHER", data, order);
    }

    @Test
    void testAddPayment() {
        Map<String, String> data = new HashMap<>();
        data.put("voucherCode", "ESHOPABC12345678");
        doReturn(payment).when(paymentRepository).save(any(Payment.class));

        Payment result = paymentService.addPayment(order, "VOUCHER", data);
        assertNotNull(result);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    void testSetStatusSuccess() {
        doReturn(payment).when(paymentRepository).save(payment);
        Payment result = paymentService.setStatus(payment, "SUCCESS");
        assertEquals("SUCCESS", result.getStatus());
        verify(orderService, times(1)).updateStatus(order.getId(), "SUCCESS");
    }

    @Test
    void testSetStatusRejected() {
        doReturn(payment).when(paymentRepository).save(payment);
        Payment result = paymentService.setStatus(payment, "REJECTED");
        assertEquals("REJECTED", result.getStatus());
        verify(orderService, times(1)).updateStatus(order.getId(), "FAILED");
    }

    @Test
    void testSetStatusOther() {
        doReturn(payment).when(paymentRepository).save(payment);
        Payment result = paymentService.setStatus(payment, "PENDING");

        assertEquals("PENDING", result.getStatus());
        verify(orderService, times(0)).updateStatus(anyString(), anyString());
    }

    @Test
    void testGetPayment() {
        doReturn(payment).when(paymentRepository).findById("pay1");
        Payment result = paymentService.getPayment("pay1");
        assertEquals("pay1", result.getId());
    }

    @Test
    void testGetAllPayments() {
        List<Payment> payments = new ArrayList<>();
        payments.add(payment);
        doReturn(payments).when(paymentRepository).getAllPayments();
        List<Payment> result = paymentService.getAllPayments();
        assertEquals(1, result.size());
    }
}