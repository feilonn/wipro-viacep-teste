package com.wipro.viacep.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelperFunctionsTest {
    final Double FRETE_NORTE = 20.83;
    final Double FRETE_NORDESTE = 15.98;
    final Double FRETE_CENTRO_OESTE = 12.50;
    final Double FRETE_SUDESTE= 7.85;
    final Double FRETE_SUL = 17.30;
    final Double FRETE_REGIAO_INVALIDA = 0.0;

    @Test
    void getFreteByRegiaoEstado() {
        assertEquals(FRETE_NORTE, HelperFunctions.getFreteByRegiaoEstado("AC"));
        assertEquals(FRETE_NORDESTE, HelperFunctions.getFreteByRegiaoEstado("MA"));
        assertEquals(FRETE_SUDESTE, HelperFunctions.getFreteByRegiaoEstado("RJ"));
        assertEquals(FRETE_SUL,HelperFunctions.getFreteByRegiaoEstado("SC"));
        assertEquals(FRETE_CENTRO_OESTE, HelperFunctions.getFreteByRegiaoEstado("GO"));
        assertEquals(FRETE_REGIAO_INVALIDA, HelperFunctions.getFreteByRegiaoEstado("NN"));
    }
}