package com.corso.java.esercitazioni.second;

public class Concatenazione {
    private String first, second;

    public Concatenazione(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public String concat() {
        return recoursiveConcat(first, second);
    }

    private String recoursiveConcat(String first, String second) {
        if (first.length() == 0 || second.length() == 0)
            return first + second;

        return first.charAt(0) +
                recoursiveConcat(
                        first.substring(1),
                        second.substring(0, second.length()-1)
                ) +
                second.charAt(second.length() - 1);
    }
}
