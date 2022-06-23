package br.com.dbc.contacorrente2.interfaces;

import br.com.dbc.contacorrente2.model.Conta;

public interface Movimentacao {
	
	public boolean sacar(double valor);
	
	public boolean depositar(double valor);
	
	public boolean transferir(Conta conta, double valor);
}
