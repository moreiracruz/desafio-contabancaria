package com.sistema.contabancaria;

public class ContaBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private double chequeEspecialUsado;

    public ContaBancaria(double depositoInicial) {
        if (depositoInicial < 0) {
            throw new IllegalArgumentException("Depósito inicial não pode ser negativo.");
        }
        this.saldo = depositoInicial;
        this.limiteChequeEspecial = calcularLimiteChequeEspecial(depositoInicial);
        this.chequeEspecialUsado = 0;
    }

    private double calcularLimiteChequeEspecial(double depositoInicial) {
        return depositoInicial <= 500 ? 50 : depositoInicial * 0.5;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
        saldo += valor;
        cobrarTaxaChequeEspecial();
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo.");
        }
        double saldoDisponivel = saldo + limiteChequeEspecial - chequeEspecialUsado;
        if (valor > saldoDisponivel) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        if (valor > saldo) {
            chequeEspecialUsado += valor - saldo;
            saldo = 0;
        } else {
            saldo -= valor;
        }
    }

    public void pagarBoleto(double valor) {
        sacar(valor); // Pagar boleto é equivalente a sacar dinheiro
    }

    public boolean isUsandoChequeEspecial() {
        return chequeEspecialUsado > 0;
    }

    private void cobrarTaxaChequeEspecial() {
        if (chequeEspecialUsado > 0 && saldo > 0) {
            double taxa = chequeEspecialUsado * 0.2;
            if (saldo >= taxa) {
                saldo -= taxa;
                chequeEspecialUsado = 0;
            } else {
                chequeEspecialUsado -= saldo / 0.2;
                saldo = 0;
            }
        }
    }

    public double getSaldoDisponivel() {
        return saldo + limiteChequeEspecial - chequeEspecialUsado;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getChequeEspecialUsado() {
        return chequeEspecialUsado;
    }

}
