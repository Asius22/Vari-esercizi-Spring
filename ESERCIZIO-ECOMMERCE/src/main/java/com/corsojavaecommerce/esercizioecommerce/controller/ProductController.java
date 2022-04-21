package com.corsojavaecommerce.esercizioecommerce.controller;

import com.corsojavaecommerce.esercizioecommerce.domain.Product;
import com.corsojavaecommerce.esercizioecommerce.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/")
    ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<Product> getById(@PathParam("id") String id){
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping(path = "/")
    ResponseEntity<Product> createProduct(@RequestBody Product p){
        return ResponseEntity.ok(productService.createProduct(p));
    }
}
