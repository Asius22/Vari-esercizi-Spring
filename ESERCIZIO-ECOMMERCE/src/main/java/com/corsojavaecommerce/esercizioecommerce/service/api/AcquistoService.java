package com.corsojavaecommerce.esercizioecommerce.service.api;

import com.corsojavaecommerce.esercizioecommerce.domain.Acquisto;

import java.util.List;

public interface AcquistoService {
    List<Acquisto> getAll();
    Acquisto create(Acquisto a);
}
