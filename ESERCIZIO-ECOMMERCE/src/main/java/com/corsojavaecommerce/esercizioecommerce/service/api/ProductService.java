package com.corsojavaecommerce.esercizioecommerce.service.api;

import com.corsojavaecommerce.esercizioecommerce.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    List<Product> getByName(String name);
    Product getById(String id);
    List<Product> getByPrice(double price);
    Product createProduct(Product p);
    void deleteById(String id);

}
