package br.com.dbc.contacorrente.main.classes;

import br.com.dbc.contacorrente.main.interfaces.Impressao;

import java.text.DecimalFormat;

public class ContaPagamento extends Conta implements Impressao {

    static final double TAXA_SAQUE = 4.25;

    DecimalFormat df = new DecimalFormat("0.00");

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public ContaPagamento() {

    }

    @Override
    public void imprimir() {
        System.out.println("-----------------------------------" + "\n" +
                "Cliente: "                   + getCliente() + "\n" +
                "Agência: "                   + getAgencia() + "\n" +
                "Conta: "                     + getNumeroConta() + "\n" +
                "Saldo: R$"                   + df.format(this.getSaldo()));
    }
    @Override
    public boolean sacar(double valor) {
            if (this.getSaldo() > 0  && valor+TAXA_SAQUE < getSaldo()) {
                setSaldo(getSaldo()-TAXA_SAQUE-valor);
                System.out.println("-----------------------------------" + "\n" +
                                   "saque efetuado");
                return true;
                //return super.sacar(valor);
            }
        System.out.println("-----------------------------------" + "\n" +
                           "saque negado");
        return false;
    }
}
