package com.sistema.contabancaria;

import java.util.Scanner;

public class BancoApplication {

	public static void main(String[] args) {
		new BancoApplication().run();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem-vindo ao Sistema Bancário!");

		System.out.println("Digite o valor do depósito inicial:");
		double depositoInicial = scanner.nextDouble();
		ContaBancaria conta = new ContaBancaria(depositoInicial);

		while (true) {
			System.out.println("\nEscolha uma operação:");
			System.out.println("1 - Consultar saldo");
			System.out.println("2 - Consultar cheque especial");
			System.out.println("3 - Depositar dinheiro");
			System.out.println("4 - Sacar dinheiro");
			System.out.println("5 - Pagar boleto");
			System.out.println("6 - Verificar uso de cheque especial");
			System.out.println("7 - Sair");
			int opcao = scanner.nextInt();

			switch (opcao) {
				case 1:
					System.out.println("Saldo: R$" + conta.getSaldo());
					break;
				case 2:
					System.out.println("Limite do cheque especial: R$" + conta.getLimiteChequeEspecial());
					break;
				case 3:
					System.out.println("Digite o valor do depósito:");
					double valorDeposito = scanner.nextDouble();
					conta.depositar(valorDeposito);
					System.out.println("Depósito realizado com sucesso.");
					break;
				case 4:
					System.out.println("Digite o valor do saque:");
					double valorSaque = scanner.nextDouble();
					conta.sacar(valorSaque);
					System.out.println("Saque realizado com sucesso.");
					break;
				case 5:
					System.out.println("Digite o valor do boleto:");
					double valorBoleto = scanner.nextDouble();
					conta.pagarBoleto(valorBoleto);
					System.out.println("Boleto pago com sucesso.");
					break;
				case 6:
					System.out.println("Usando cheque especial? " + conta.isUsandoChequeEspecial());
					break;
				case 7:
					System.out.println("Saindo...");
					scanner.close();
					return;
				default:
					System.out.println("Opção inválida.");
			}
		}
	}

}
