package id.ac.ui.cs.advprog.eshop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    public String paymentDetail() {
        return null;
    }

    public String paymentDetailById(@PathVariable String paymentId) {
        return null;
    }

    public String paymentAdminList() {
        return null;
    }

    public String paymentAdminDetail(@PathVariable String paymentId) {
        return null;
    }

    public String paymentSetStatus(@PathVariable String paymentId) {
        return null;
    }
}