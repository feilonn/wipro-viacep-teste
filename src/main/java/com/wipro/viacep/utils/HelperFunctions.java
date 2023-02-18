package com.wipro.viacep.utils;

import java.util.Arrays;

public class HelperFunctions {
    public static Double getFreteByRegiaoEstado(String uf) {
        uf = uf.toUpperCase();
        String[] norte = {"AC", "AM", "AP", "PA", "RO", "RR", "TO"};
        String[] nordeste = {"AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE"};
        String[] centroOeste = {"GO", "MT", "MS", "DF"};
        String[] sudeste = {"ES", "MG", "RJ", "SP"};
        String[] sul = {"PR", "RS", "SC"};

        if (Arrays.asList(norte).contains(uf)) {
            return 20.83;
        } else if (Arrays.asList(nordeste).contains(uf)) {
            return 15.98;
        } else if (Arrays.asList(centroOeste).contains(uf)) {
            return 12.50;
        } else if (Arrays.asList(sudeste).contains(uf)) {
            return 7.85;
        } else if (Arrays.asList(sul).contains(uf)) {
            return 17.30;
        } else {
            return 0.0;
        }
    }
}
