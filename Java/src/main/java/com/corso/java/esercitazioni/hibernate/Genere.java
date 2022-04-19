package com.corso.java.esercitazioni.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genere {
    @Id
    private String nome;

    public Genere(String nome){
        this.nome = nome;
    }

    public Genere(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
