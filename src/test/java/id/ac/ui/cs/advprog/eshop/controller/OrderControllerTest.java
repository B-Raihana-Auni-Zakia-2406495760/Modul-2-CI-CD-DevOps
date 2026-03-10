package id.ac.ui.cs.advprog.eshop.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateOrderPage() throws Exception {
        mockMvc.perform(get("/order/create")).andExpect(status().isOk());
    }
    @Test
    void testHistoryOrderPage() throws Exception {
        mockMvc.perform(get("/order/history")).andExpect(status().isOk());
    }
    @Test
    void testHistoryOrderPost() throws Exception {
        mockMvc.perform(post("/order/history")).andExpect(status().isOk());
    }
    @Test
    void testPayOrderPage() throws Exception {
        mockMvc.perform(get("/order/pay/123")).andExpect(status().isOk());
    }
    @Test
    void testPayOrderPost() throws Exception {
        mockMvc.perform(post("/order/pay/123")).andExpect(status().isOk());
    }
}