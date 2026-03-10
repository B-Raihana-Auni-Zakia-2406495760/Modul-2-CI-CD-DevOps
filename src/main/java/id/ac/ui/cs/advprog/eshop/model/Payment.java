package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Payment {
    private String id;
    private String method;

    private String status;
    private Map<String, String> paymentData;
    private Order order;

    public Payment(String id, String method, Map<String, String> paymentData, Order order) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        this.order = order;

        if ("VOUCHER".equals(method)) {
            String code = paymentData.get("voucherCode");
            if (code != null && code.length() == 16 && code.startsWith("ESHOP") && code.chars().filter(Character::isDigit).count() == 8) {
                this.status = "SUCCESS";
            } else {
                this.status = "REJECTED";
            }
        } else if ("BANK".equals(method)) {
            String bankName = paymentData.get("bankName");
            String refCode = paymentData.get("referenceCode");
            if (bankName != null && !bankName.trim().isEmpty() && refCode != null && !refCode.trim().isEmpty()) {
                this.status = "SUCCESS";
            } else {
                this.status = "REJECTED";
            }
        } else {
            this.status = "REJECTED";
        }
    }

}