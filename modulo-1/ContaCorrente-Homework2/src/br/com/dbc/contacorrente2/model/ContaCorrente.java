package br.com.dbc.contacorrente2.model;

import br.com.dbc.contacorrente2.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {
	
	private Double chequeEspecial;
	
	public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
		setCliente(cliente);
		setNumeroConta(numeroConta);
		setAgencia(agencia);
		setSaldo(saldo);
		this.chequeEspecial = chequeEspecial;
	}

	public double retornarSaldoComChequeEspecial() {
		return getSaldo() + chequeEspecial;
	}

	public void setChequeEspecial(Double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
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
		if (valor > 0 && valor <= retornarSaldoComChequeEspecial()) {
			setSaldo(getSaldo() - valor);
			//conta.setSaldo(getSaldo() + valor);
			//deposita na poupança
			conta.depositar(valor);
			System.out.println("Transferencia realizada com sucesso");
			return true;
		}
		System.out.println("Transferencia negada");
		return false;
	}

	@Override
	public boolean sacar(double valor) {
		if (valor > 0 && valor <= retornarSaldoComChequeEspecial()) {
			setSaldo(getSaldo() - valor);
			System.out.println("Saque realizado com sucesso");
			return true;
		}
		System.out.println("Saque negado");
		return false;
	}

	@Override
	public void imprimir() {
		System.out.println("Nome: " + getCliente() + " Conta Corrente Nº: " + getNumeroConta() + "Agencia: " + getAgencia() + "Saldo: " + getSaldo() + "Saldo + Cheque Especial: " + retornarSaldoComChequeEspecial());		
	}	
	
}
