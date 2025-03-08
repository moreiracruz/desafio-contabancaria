package com.sistema.contabancaria;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    @Test
    void testContaBancaria() {
        ContaBancaria conta = new ContaBancaria(1000);
        assertEquals(1000, conta.getSaldo());
        assertEquals(500, conta.getLimiteChequeEspecial());
    }

    @Test
    void testDepositar() {
        ContaBancaria conta = new ContaBancaria(1000);
        conta.depositar(500);
        assertEquals(1500, conta.getSaldo());
    }

    @Test
    void testSacar() {
        ContaBancaria conta = new ContaBancaria(1000);
        conta.sacar(500);
        assertEquals(500, conta.getSaldo());
    }

    @Test
    void testPagarBoleto() {
        ContaBancaria conta = new ContaBancaria(1000);
        conta.pagarBoleto(500);
        assertEquals(500, conta.getSaldo());
    }

    @Test
    void testUsandoChequeEspecial() {
        ContaBancaria conta = new ContaBancaria(1000);
        conta.sacar(1200);
        assertTrue(conta.isUsandoChequeEspecial());
    }

    @Test
    void testCobrarTaxaChequeEspecial() {
        ContaBancaria conta = new ContaBancaria(1000);
        conta.sacar(1200); // Usa R$200 do cheque especial
        conta.depositar(100); // Cobra 20% de R$200 = R$40
        assertEquals(60, conta.getSaldo());
        assertEquals(0, conta.getChequeEspecialUsado());
    }

}
