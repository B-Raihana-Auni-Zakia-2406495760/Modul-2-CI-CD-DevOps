package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HomeControllerTest {
    @Autowired
    private HomeController homeController;

    @Test
    void testHomePage() {
        String viewName = homeController.homePage();
        assertEquals("home", viewName);
    }
}