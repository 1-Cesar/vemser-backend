package br.com.dbc.contacorrente.main.interfaces;

import br.com.dbc.contacorrente.main.classes.Conta;

public interface Movimentacao {

    public boolean sacar(double valor);

    public boolean depositar(double valor);

    public boolean transferir(Conta conta, double valor);
}
