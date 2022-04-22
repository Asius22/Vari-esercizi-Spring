package com.corso.java.test.service;

import com.corso.java.test.domain.Product;
import com.corso.java.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByid(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product deleteProductById(int id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product != null)
            productRepository.deleteById(id);

        return product;
    }
}
