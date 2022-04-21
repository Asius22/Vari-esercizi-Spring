package com.corsojavaecommerce.esercizioecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("acquisti")
public class Acquisto {
    @Id
    private String id;
    private List<Product> prodotti;
}
