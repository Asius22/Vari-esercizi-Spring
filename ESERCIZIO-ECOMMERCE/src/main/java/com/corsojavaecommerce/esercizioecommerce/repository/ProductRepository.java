package com.corsojavaecommerce.esercizioecommerce.repository;

import com.corsojavaecommerce.esercizioecommerce.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findByName(String name);

    List<Product> findByPrice(double price);
}
