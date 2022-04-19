package com.corso.java.esercitazioni.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Album {
    @Id
    private String nomeAlbum;
    @OneToOne
    private Artista artista;

    public Album(){}

    public Album(String nomeAlbum, Artista artista) {
        this.nomeAlbum = nomeAlbum;
        this.artista = artista;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
