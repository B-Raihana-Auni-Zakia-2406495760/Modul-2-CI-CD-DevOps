package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @Autowired
    private ProductService productService;

    @Test
    void testCreateProductPage() {
        Model model = new ConcurrentModel();
        String viewName = productController.createProductPage(model);
        assertEquals("createProduct", viewName);
        assertTrue(model.containsAttribute("product"));
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductQuantity(10);
        Model model = new ConcurrentModel();
        String viewName = productController.createProductPost(product, model);
        assertEquals("redirect:list", viewName);
        List<Product> products = productService.findAll();
        boolean exists = products.stream().anyMatch(p -> p.getProductName().equals("Test Product"));
        assertTrue(exists);
    }

    @Test
    void testProductListPage() {
        Model model = new ConcurrentModel();
        String viewName = productController.productListPage(model);
        assertEquals("productList", viewName);
        assertTrue(model.containsAttribute("products"));
    }

    @Test
    void testEditProductPage() {
        Product product = new Product();
        product.setProductName("Original");
        productService.create(product);
        String id = product.getProductId();
        Model model = new ConcurrentModel();
        String viewName = productController.editProductPage(id, model);
        assertEquals("editProduct", viewName);
        assertTrue(model.containsAttribute("product"));
    }

    @Test
    void testEditProductPost() {
        Product product = new Product();
        product.setProductName("Original");
        productService.create(product);
        product.setProductName("Changed");
        String viewName = productController.editProductPost(product);
        assertEquals("redirect:list", viewName);
        Product updated = productService.findById(product.getProductId());
        assertEquals("Changed", updated.getProductName());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductName("To Delete");
        productService.create(product);
        String id = product.getProductId();
        String viewName = productController.deleteProduct(id);
        assertEquals("redirect:../list", viewName);
        Product deleted = productService.findById(id);
        assertNull(deleted);
    }
}