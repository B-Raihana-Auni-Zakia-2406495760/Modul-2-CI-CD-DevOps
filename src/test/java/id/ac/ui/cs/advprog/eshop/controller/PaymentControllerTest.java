package id.ac.ui.cs.advprog.eshop.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
class PaymentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPaymentDetailPage() throws Exception {
        mockMvc.perform(get("/payment/detail")).andExpect(status().isOk());
    }
    @Test
    void testPaymentDetailByIdPage() throws Exception {
        mockMvc.perform(get("/payment/detail/123")).andExpect(status().isOk());
    }
    @Test
    void testAdminListPage() throws Exception {
        mockMvc.perform(get("/payment/admin/list")).andExpect(status().isOk());
    }
    @Test
    void testAdminDetailPage() throws Exception {
        mockMvc.perform(get("/payment/admin/detail/123")).andExpect(status().isOk());
    }
    @Test
    void testAdminSetStatus() throws Exception {
        mockMvc.perform(post("/payment/admin/set-status/123")).andExpect(status().isOk());
    }
}