package test.repository;

import test.domain.Product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import test.repository.ProductRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    public void setUp() {
        product = new Product(1, "Bat", 2500);
    }

    @AfterEach
    public void tearDown() {
        productRepository.deleteAll();
        product = null;
    }

    @Test
    public void givenProductToAddShouldReturnAddedProduct() {

        productRepository.save(product);
        Product fetchedProduct = productRepository.findById(product.getId()).get();
        assertEquals(1, fetchedProduct.getId());
    }

    @Test
    public void GivenGetAllProductShouldReturnOfAddedProduct() {

        Product product1 = new Product(2, "ball", 5);
        Product product2 = new Product(3, "bat", 12);
        productRepository.save(product1);
        productRepository.save(product2);

        List<Product> productList = (List<Product>) productRepository.findAll();
        assertEquals("bat", productList.get(1).getName());
    }

    @Test
    public void givenIdTODeleteThenShouldDeleteTheProduct() {
        Product product = new Product(4, "computer", 1200);
        productRepository.save(product);
        productRepository.deleteById(product.getId());

        Product p = productRepository.findById(product.getId()).orElse(null);

        assertNull(p);

    }
}
