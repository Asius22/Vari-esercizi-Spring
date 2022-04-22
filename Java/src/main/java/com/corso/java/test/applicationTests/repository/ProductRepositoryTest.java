package com.corso.java.test.applicationTests.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.corso.java.test.domain.Product;
import com.corso.java.test.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    public void setUp(){
        product = new Product(1, "Bat", 2500);
    }

    @Test
    public void givenProductToAddShouldReturnAddedProduct() {

        productRepository.save(product);
        Product fetchedProduct = productRepository.findById(product.getId()).orElse(null);
        assertEquals(1, fetchedProduct.getId());
    }

    @AfterEach
    public void tearDown(){
        productRepository.deleteAll();
        product = null;
    }
}
