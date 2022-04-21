package com.corsojavaecommerce.esercizioecommerce.service;

import com.corsojavaecommerce.esercizioecommerce.domain.Acquisto;
import com.corsojavaecommerce.esercizioecommerce.repository.AcquistoRepository;
import com.corsojavaecommerce.esercizioecommerce.service.api.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcquistoServiceImpl implements AcquistoService {

    @Autowired
    AcquistoRepository acquistoRepository;

    @Override
    public List<Acquisto> getAll() {
        return acquistoRepository.findAll();
    }

    @Override
    public Acquisto create(Acquisto a) {
        return acquistoRepository.save(a);
    }
}
