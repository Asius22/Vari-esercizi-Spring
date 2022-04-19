package com.corso.java.esercitazioni.first;

import java.util.*;

public class InsiemeDiStringhe {
    private Set<String> insieme;

    public InsiemeDiStringhe(String[] lista) {
        insieme = new HashSet<>();
        insieme.addAll(Arrays.stream(lista).toList());
    }

    public String stringaLunga() {
        String max = "";

        for (String s : insieme)
            if (s.length() > max.length()) max = s;
        return max;
    }

    public String spaziStringa() {
        long count = 0, tmp = 0;
        String res = "";
        for (String s : insieme) {
            tmp = s.chars().filter(ch -> ch == ' ').count();
            if (count < tmp) {
                count = tmp;
                res = s;
            }
        }
        return res;
    }

    public List<String> preStringa(String prefix) {
        List<String> res = new ArrayList<>();

        for (String s : insieme)
            if (s.startsWith(prefix))
                res.add(s);
        return res;
    }

    private int countSpaces(char[] s) {
        int count = 0;

        for (char c : s)
            if (c == ' ') count++;
        return count;
    }
}
