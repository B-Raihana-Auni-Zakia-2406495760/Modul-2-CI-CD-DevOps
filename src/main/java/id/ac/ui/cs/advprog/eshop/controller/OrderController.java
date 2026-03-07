package id.ac.ui.cs.advprog.eshop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    public String createOrder() {
        return null;
    }

    public String historyOrder() {
        return null;
    }

    public String historyOrderPost() {
        return null;
    }

    public String payOrder(@PathVariable String orderId) {
        return null;
    }

    public String payOrderPost(@PathVariable String orderId) {
        return null;
    }
}