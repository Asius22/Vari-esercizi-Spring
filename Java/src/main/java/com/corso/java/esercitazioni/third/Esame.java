package com.corso.java.esercitazioni.third;

import java.util.Objects;

public class Esame {
    private String nome;
    private int crediti;
    private int voto;

    public Esame(String nome, int crediti) {
        this.nome = nome;
        this.crediti = crediti;
    }

    public Esame(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCrediti() {
        return this.crediti;
    }

    public int getVoto() {
        return this.voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String toString() {
        return this.getClass().getName() + "[ " +
                "nome = " + this.nome +
                ", crediti = " + this.crediti + " CFU" +
                ", voto = " + this.voto + "/30}";
    }

    /**
     * essendo che non ci sono esami con lo stesso nome
     * posso basarmi su questa proprieta per confrontare duee sami
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Esame esame)) return false;
        if (this == o) return true;
        return getNome().equals(esame.getNome());
    }

}