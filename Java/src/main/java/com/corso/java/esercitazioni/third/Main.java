package com.corso.java.esercitazioni.third;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Crea esami
        Esame[] e = {
                new Esame("SO", 9),
                new Esame("PSD", 9),
                new Esame("BD", 9),
                new Esame("Programmazione 1", 9),
        } ;

        CorsoLaurea corsoLaurea = new CorsoLaurea("Informatica");
        corsoLaurea.iscrivi("ciro");
        corsoLaurea.iscrivi("vincenzo");
        corsoLaurea.iscrivi("pasquale");
        corsoLaurea.iscrivi("gianluca");
        corsoLaurea.iscrivi("leonardo");
        for (Studente s : corsoLaurea.getImmatricolati())
            s.setPianodiStudi(Arrays.stream(e).toList());

        corsoLaurea.appello("SO", corsoLaurea.getImmatricolati());

        for (Studente s : corsoLaurea.getImmatricolati())
            System.out.println(s);
    }
}
