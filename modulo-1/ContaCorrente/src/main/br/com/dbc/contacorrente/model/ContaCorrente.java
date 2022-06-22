package main.br.com.dbc.contacorrente.model;

public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public Double saldo, chequeEspecial;
    public void imprimirContaCorrente() {
        System.out.println("--------------------");

        System.out.println("\nNome do Cliente: "                           + cliente.nome + "\n" +
                           "Número da Agência: "                           + agencia    + "\n" +
                           "Número da Conta Corrente: "                    + numeroConta + "\n" +
                           "Saldo da Conta Corrente: "                     + saldo        + "\n" +
                           "Limite de Cheque Especial da Conta Corrente: " + chequeEspecial);
    }
    public double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }
    public boolean sacar(double valor) {
        if(valor > 0 && valor <= retornarSaldoComChequeEspecial()) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar(double valor) {
        if(valor > 0) {
            saldo += valor;
            return true;
        }
        return false;
    }
    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        if(valor > 0 && valor <= retornarSaldoComChequeEspecial()) {
            saldo -= valor;
            contaCorrente.saldo += valor;
            System.out.println("Transferencia efetuada com sucesso!");
            return true;
        }
        return false;
    }
}
