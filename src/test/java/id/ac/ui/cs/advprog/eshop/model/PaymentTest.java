package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    Order order;
    Map<String, String> paymentDataVoucher;
    Map<String, String> paymentDataBank;
    java.util.List<Product> products;

    @BeforeEach
    void setUp() {
        products = new java.util.ArrayList<>();
        Product dummy = new Product();
        dummy.setProductId("prod1");
        dummy.setProductName("kecap");
        dummy.setProductQuantity(1);
        products.add(dummy);

        order = new Order("order1", products, 123L, "laffar");

        paymentDataVoucher = new HashMap<>();
        paymentDataVoucher.put("voucherCode", "ESHOPABC12345678");

        paymentDataBank = new HashMap<>();
        paymentDataBank.put("bankName", "ABC");
        paymentDataBank.put("referenceCode", "REF123");
    }

    @Test
    void testCreatePaymentVoucherSuccess() {
        Payment payment = new Payment("pay1", "VOUCHER", paymentDataVoucher, order);
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankSuccess() {
        Payment payment = new Payment("pay3", "BANK", paymentDataBank, order);
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePaymentVoucherRejectedLength() {
        paymentDataVoucher.put("voucherCode", "INVALID");
        Payment payment = new Payment("pay2", "VOUCHER", paymentDataVoucher, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentVoucherNullCode() {
        paymentDataVoucher.remove("voucherCode");
        Payment payment = new Payment("pay", "VOUCHER", paymentDataVoucher, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentVoucherNotStartWithEshop() {
        paymentDataVoucher.put("voucherCode", "ABCDEFGH12345678");
        Payment payment = new Payment("pay", "VOUCHER", paymentDataVoucher, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentVoucherNot8Digits() {
        paymentDataVoucher.put("voucherCode", "ESHOPABCDEF12345");
        Payment payment = new Payment("pay", "VOUCHER", paymentDataVoucher, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankEmptyBankName() {
        paymentDataBank.put("bankName", "   ");
        Payment payment = new Payment("pay4", "BANK", paymentDataBank, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankNullBankName() {
        paymentDataBank.remove("bankName");
        Payment payment = new Payment("pay4", "BANK", paymentDataBank, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankNullReferenceCode() {
        paymentDataBank.remove("referenceCode");
        Payment payment = new Payment("pay", "BANK", paymentDataBank, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentBankEmptyReferenceCode() {
        paymentDataBank.put("referenceCode", "");
        Payment payment = new Payment("pay", "BANK", paymentDataBank, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCreatePaymentUnknownMethod() {
        Payment payment = new Payment("pay", "PAYLATER", paymentDataVoucher, order);
        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testGettersAndSetters() {
        Payment payment = new Payment("pay1", "VOUCHER", paymentDataVoucher, order);

        payment.setId("new-id");
        payment.setMethod("BANK");

        Map<String, String> newData = new HashMap<>();
        newData.put("bankName", "ABC");
        payment.setPaymentData(newData);

        Order newOrder = new Order("order2", products, 123L, "laffar");
        payment.setOrder(newOrder);

        assertEquals("new-id", payment.getId());
        assertEquals("BANK", payment.getMethod());
        assertEquals(newData, payment.getPaymentData());
        assertEquals(newOrder, payment.getOrder());
    }
}