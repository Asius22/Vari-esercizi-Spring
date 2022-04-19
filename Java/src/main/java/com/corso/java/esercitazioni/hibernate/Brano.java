package com.corso.java.esercitazioni.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Brano {
    @Id
    private String nome;
    @OneToOne
    private Album album;
    @OneToOne
    private Genere genere;

    public Brano(){}

    public Brano(String nome, Album album, Genere genere) {
        this.nome = nome;
        this.album = album;
        this.genere = genere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
