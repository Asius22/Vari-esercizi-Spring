package com.corsojavaecommerce.esercizioecommerce.service;

import com.corsojavaecommerce.esercizioecommerce.domain.Product;
import com.corsojavaecommerce.esercizioecommerce.repository.ProductRepository;
import com.corsojavaecommerce.esercizioecommerce.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByName(String name) { //TODO implementa in repository
        return productRepository.findByName(name);
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getByPrice(double price) { //todo implementa in repository
        return productRepository.findByPrice(price);
    }

    @Override
    public Product createProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
