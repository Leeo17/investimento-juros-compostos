package com.example.investimento;

import junit.framework.TestCase;

public class InvestimentoTest extends TestCase {
    public void testaCalculoJurosCompostos() {
        double capital = 50.25;
        int prazo = 12;
        double juros = 10.5;
        double resultadoEsperado = 166.53;

        double resultado = Investimento.calcularJurosCompostos(capital, prazo, juros);

        assertEquals(resultadoEsperado, resultado);
    }
}
