package id.ac.ui.cs.advprog.eshop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/create")
    public String createOrder() {
        return "order/create";
    }

    @GetMapping("/history")
    public String historyOrder() {
        return "order/history";
    }

    @PostMapping("/history")
    public String historyOrderPost() {
        return "order/history";
    }

    @GetMapping("/pay/{orderId}")
    public String payOrder(@PathVariable String orderId) {
        return "order/pay";
    }

    @PostMapping("/pay/{orderId}")
    public String payOrderPost(@PathVariable String orderId) {
        return "order/pay";
    }
}