package test.service;

import java.util.List;

import test.domain.Product;

public interface ProductService {

    Product addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductByid(int id);

    Product deleteProductById(int id);

}
