package com.corso.java.esercitazioni.first;

public class Test {
    public static void main(String[] args) {
        String[] array = {"ciao", "c i a o", "frase lunga", "fra poco mangio", "ciao come stai?"};
        InsiemeDiStringhe insieme = new InsiemeDiStringhe(array);

        System.out.println(insieme.spaziStringa());
        System.out.println(insieme.stringaLunga());
        System.out.println("prefisso : 'c'" + insieme.preStringa("c"));
        System.out.println("prefisso : 'fra'" + insieme.preStringa("fra"));
    }
}
