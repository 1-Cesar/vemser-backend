package br.com.dbc.contacorrente.main.classes;

import br.com.dbc.contacorrente.main.interfaces.Impressao;
public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;
    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }
    public double retornarSaldoComChequeEspecial() {
         return getSaldo() + chequeEspecial;
    }
    @Override
    public boolean sacar(double valor) {
        //return super.sacar(valor);
        if (valor > 0 && valor <= retornarSaldoComChequeEspecial()) {
            System.out.println("-----------------------------------" + "\n" +
                               "Saque realizado com sucesso!");
            System.out.println("Saldo Anterior: " + getSaldo());
            setSaldo(getSaldo() - valor);
            return true;
        }
        System.out.println("-----------------------------------" + "\n" +
                           "Saque Negado");
        return false;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    @Override
    public void imprimir() {
        System.out.println("-----------------------------------" + "\n" +
                           "Conta Corrente" + "\n" +
                           "Cliente: "                   + getCliente() + "\n" +
                           "Agência: "                   + getAgencia() + "\n" +
                           "Conta: "                     + getNumeroConta() + "\n" +
                           "Saldo: R$"                   + getSaldo() + "\n" +
                           "Cheque Especial: R$"         + chequeEspecial + "\n" +
                           "Saldo + Cheque Especial: R$" + retornarSaldoComChequeEspecial());
    }
}
