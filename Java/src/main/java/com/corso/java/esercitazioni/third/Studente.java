package com.corso.java.esercitazioni.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Studente {
    private String nome;
    private int matricola;
    private List<Esame> esamiSostenuti;
    private List<Esame> pianoStudio;

    public Studente(String nome, int matricola) {
        this.nome = nome;
        this.matricola = matricola;
        esamiSostenuti = new ArrayList<>();
        pianoStudio = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricola() {
        return String.valueOf(this.matricola);
    }

    public void setPianodiStudi(List<Esame> pianodiStudi) {
        this.pianoStudio = pianodiStudi;
    }

    public void aggiungiEsame(String nome, int crediti) {
        this.pianoStudio.add(
                new Esame(nome, crediti)
        );
    }

    public void promosso(String esame, int voto) {

        for (Esame e : pianoStudio)
            if (e.getNome().equals(esame)) {
                e.setVoto(voto);
                esamiSostenuti.add(e);
            }
    }

    public void cancella(String nome) {
        esamiSostenuti.remove(
                new Esame(nome)
        );
    }

    public double media() {
        double media = 0;
        for (Esame e : esamiSostenuti)
            media += e.getVoto();

        return media / esamiSostenuti.size();
    }

    public double crediti() {
        int crediti = 0;
        for (Esame e : esamiSostenuti)
            crediti += e.getCrediti();

        return crediti;
    }

    /**
     * TODO
     *
     * @return
     */
    public String toString() {
        return this.getNome().getClass() + "[" +
                "nome = " + this.nome +
                ", matricola = " + this.matricola +
                ", crediti = " + this.crediti() +
                ", esami sostenuti = " + this.esamiSostenuti +
                ", piano di studi = " + this.pianoStudio + "];";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Studente studente)) return false;
        return studente.getMatricola().equals(getMatricola())
                && getNome().equals(studente.getNome())
                && esamiSostenuti.equals(studente.esamiSostenuti)
                && pianoStudio.equals(studente.pianoStudio);
    }

}