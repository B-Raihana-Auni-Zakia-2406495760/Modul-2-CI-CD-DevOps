package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @Test
    void testCreateAndFindAll() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);
        List<Product> productList = productService.findAll();
        assertNotNull(productList);

        boolean found = false;
        for (Product p : productList) {
            if (p.getProductId().equals(product.getProductId())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductName("Find Me");
        productService.create(product);
        Product found = productService.findById(product.getProductId());
        assertEquals(product.getProductId(), found.getProductId());
        assertEquals("Find Me", found.getProductName());
    }

    @Test
    void testEdit() {
        Product product = new Product();
        product.setProductName("Before Edit");
        product.setProductQuantity(10);
        productService.create(product);
        Product updatedData = new Product();
        updatedData.setProductId(product.getProductId());
        updatedData.setProductName("After Edit");
        updatedData.setProductQuantity(20);
        productService.edit(updatedData);
        Product result = productService.findById(product.getProductId());
        assertEquals("After Edit", result.getProductName());
        assertEquals(20, result.getProductQuantity());
    }

    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductName("Delete Me");
        productService.create(product);
        String id = product.getProductId();
        productService.delete(id);
        Product result = productService.findById(id);
        assertNull(result);
    }
}