package com.corso.java.esercitazioni.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CorsoLaurea {
    private String nome;
    private List<Studente> immatricolati;
    public static int prossimaMatricola;
    public static final int MIN_CREDITI = 180;

    public CorsoLaurea(String nome) {
        this.nome = nome;
        immatricolati = new ArrayList<>();
        prossimaMatricola = 12345;
    }

    public String getNome() {
        return this.nome;
    }

    public List<Studente> getImmatricolati() {
        return this.immatricolati;
    }

    public void iscrivi(String nome) {
        int matricola = prossimaMatricola + immatricolati.size();
        Studente s = new Studente(nome, matricola);
        this.immatricolati.add(s);
    }

    public void ritira(String nome) {
        for (Studente s : immatricolati)
            if (s.getNome().equals(nome)) {
                immatricolati.remove(s);
                return;
            }
    }

    public void appello(String esame, List<Studente> iscritti) {
        for (Studente s : iscritti) {
            int voto = new Random().nextInt(30);
            if (voto >= 18)
                s.promosso(esame, voto);
        }

        laurea();
    }

    public void laurea() {
        immatricolati.removeIf(s -> s.crediti() >= MIN_CREDITI);
    }
}