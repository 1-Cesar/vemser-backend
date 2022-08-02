package br.com.dbc.contacorrente.main.classes;

import br.com.dbc.contacorrente.main.interfaces.Impressao;
import java.text.DecimalFormat;
public class ContaPoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;
    DecimalFormat df = new DecimalFormat("0.00");

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public ContaPoupanca() {

    }

    public void creditarTaxa() {
        double a = (getSaldo()*(JUROS_MENSAL/100) + this.getSaldo());
        setSaldo(a);
    }
    @Override
    public void imprimir() {
        System.out.println("-----------------------------------" + "\n" +
                "Conta Poupança"              + "\n" +
                "Cliente: "                   + getCliente()    + "\n" +
                "Agência: "                   + getAgencia() + "\n" +
                "Conta: "                     + getNumeroConta() + "\n" +
                "Saldo: R$"                   + df.format(this.getSaldo()));
        System.out.println("Novo Saldo com Juros do Próximo Aniversário da Conta R$");
        creditarTaxa();

    }
}
