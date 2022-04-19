package com.corso.java.esercitazioni.hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Archivio {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToMany
    private Set<Album> cds;

    @OneToMany
    private Set<Artista> artisti;

    @OneToMany
    private Set<Genere> generi;

    @OneToMany
    private Set<Brano> brani;
    public Archivio(){}

    public Archivio(String id) {
        this.id = id;
        this.cds = new HashSet<>();
        this.artisti = new HashSet<>();
        this.generi = new HashSet<>();
        this.brani = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Album> getCds() {
        return cds;
    }

    public void aggiungiCD(Album cd) {
        if (!cds.contains(cd))
            cds.add(cd);
    }

    public Set<Artista> getArtisti() {
        return artisti;
    }

    public void addArtista(Artista artista) {
        if (!artisti.contains(artista))
            artisti.add(artista);
    }

    public Set<Genere> getGeneri() {
        return generi;
    }

    public void addGenere(Genere genere) {
        if (!generi.contains(genere))
            generi.add(genere);
    }

    public Set<Brano> getBrani() {
        return brani;
    }

    public void aggiungiBrano(Brano brano) {
        if (!brani.contains(brano))
            brani.add(brano);
        addGenere(brano.getGenere());
        aggiungiCD(brano.getAlbum());
    }
}
