package br.com.dbc.contacorrente.main.classes;

import br.com.dbc.contacorrente.main.interfaces.Movimentacao;
public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta, agencia;
    private double saldo;
    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Conta() {

    }

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
    public double getSaldo() {
        return saldo;
    }
    public boolean setSaldo(double saldo) {
        this.saldo = saldo;
        return true;
    }
    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor < getSaldo()) {
            retirarDinheiro(valor);
            return true;
        }
        return false;
    }
    @Override
    public boolean depositar(double valor) {
        if(valor > 0) {
            setSaldo(getSaldo()+valor);
            System.out.println("-----------------------------------" + "\n" +
                               "Depósito Realizado com Sucesso!");
            return true;
        }
        System.out.println("-----------------------------------" + "\n" +
                           "Depósito Inválido");
        return false;
    }
    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor > 0 && valor <= saldo) {
            retirarDinheiro(valor);
            conta.depositar(valor);
            System.out.println("Transferencia Realizada!");
            return true;
        }
        return false;
    }

    private void retirarDinheiro(double valor){
        saldo-=valor;
    }
}
