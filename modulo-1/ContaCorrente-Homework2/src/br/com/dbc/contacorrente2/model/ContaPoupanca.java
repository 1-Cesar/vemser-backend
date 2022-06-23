package br.com.dbc.contacorrente2.model;

import br.com.dbc.contacorrente2.interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {
	static final double JUROS_MENSAL = 1.01;
	
	public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
		setCliente(cliente);
		setNumeroConta(numeroConta);
		setAgencia(agencia);
		setSaldo(saldo);
	}

	public void creditarTaxa() {
		setSaldo(getSaldo() * JUROS_MENSAL);
	}

	@Override
	public boolean sacar(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso");
			return true;
		}
		System.out.println("Saque negado");
		return false;
	}

	@Override
	public boolean depositar(double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Deposito realizado com sucesso");
			return true;
		}
		System.out.println("Deposito negado");
		return false;		
	}

	@Override
	public boolean transferir(Conta conta, double valor) {
		if (valor > 0) {
			setSaldo(getSaldo() - valor);
			conta.setSaldo(getSaldo() + valor);
			System.out.println("Transferencia realizada com sucesso");
			return true;
		}
		System.out.println("Transferencia negada");
		return false;
	}

	@Override
	public void imprimir() {
		System.out.println("ContaPoupança Nº : " + getNumeroConta() + "Agencia: " + getAgencia() + "Saldo: " + getSaldo());
		
	}
	
	
}
