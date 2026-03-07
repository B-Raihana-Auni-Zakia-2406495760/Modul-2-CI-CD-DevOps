package id.ac.ui.cs.advprog.eshop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @GetMapping("/detail")
    public String paymentDetail() {
        return "payment/detail";
    }

    @GetMapping("/detail/{paymentId}")
    public String paymentDetailById(@PathVariable String paymentId) {
        return "payment/detail";
    }

    @GetMapping("/admin/list")
    public String paymentAdminList() {
        return "payment/admin/list";
    }

    @GetMapping("/admin/detail/{paymentId}")
    public String paymentAdminDetail(@PathVariable String paymentId) {
        return "payment/admin/detail";
    }

    @PostMapping("/admin/set-status/{paymentId}")
    public String paymentSetStatus(@PathVariable String paymentId) {
        return "payment/admin/detail";
    }
}