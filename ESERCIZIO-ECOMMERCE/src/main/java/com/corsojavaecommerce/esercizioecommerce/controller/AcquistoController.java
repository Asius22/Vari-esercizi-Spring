package com.corsojavaecommerce.esercizioecommerce.controller;

import com.corsojavaecommerce.esercizioecommerce.domain.Acquisto;
import com.corsojavaecommerce.esercizioecommerce.service.api.AcquistoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("acquisti")
public class AcquistoController {
    @Autowired
    AcquistoService acquistoService;

    @GetMapping(path ="/")
    public ResponseEntity<List<Acquisto>> getAll(){
        return ResponseEntity.ok(acquistoService.getAll());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Acquisto> create(@RequestBody Acquisto a){
        return ResponseEntity.ok(acquistoService.create(a));
    }
}
