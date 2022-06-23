package br.com.dbc.contacorrente2.model;

import br.com.dbc.contacorrente2.interfaces.Movimentacao;

public abstract class Conta implements Movimentacao {
	
	private Cliente cliente = new Cliente();
	private String numeroConta, agencia;
	private Double saldo;	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}	

}
