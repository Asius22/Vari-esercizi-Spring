package com.corsojavaecommerce.esercizioecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("products")
public class Product {
    @Id
    public String id;
    public String name, description;
    public double price;
}
