package com.corsojavaecommerce.esercizioecommerce.repository;

import com.corsojavaecommerce.esercizioecommerce.domain.Acquisto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AcquistoRepository extends MongoRepository<Acquisto, String> {
}
