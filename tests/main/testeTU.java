package main;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testeTU {
    @Test
    @DisplayName("Somar dois valores positivos")
    public void deveSomarPositivos(){
        //cenario
        double v1 = 13;
        double v2 = 17.2;

        //ação
        double resultado Calculadora.somar(v1, v2);

        //validacao
        assertEquals(30.2, resultado);

    }
}
