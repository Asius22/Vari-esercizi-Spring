package com.corso.java.test.service;

import java.util.List;

import com.corso.java.test.domain.Product;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductByid(int id);

    Product deleteProductById(int id);

}