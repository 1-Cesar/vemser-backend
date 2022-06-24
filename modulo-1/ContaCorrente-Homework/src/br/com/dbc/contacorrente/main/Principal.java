package br.com.dbc.contacorrente.main;

import br.com.dbc.contacorrente.main.classes.*;
/**
 * @author cesar
 * @version vemSer
 */
public class Principal {
    public static void main(String[] args) {

        Contato vegetaTel = new Contato(1,"O Miseravel é um genio","11111-1111");
        Contato vegetaTel2 = new Contato(2,"Kakaroto é meu rival","22222-2222");

        Endereco vegetaEnd = new Endereco(1,10,"Rua dos Sayajins","Apto","11111-111","Dragon","Ball","Z");
        Endereco vegetaEnd2 = new Endereco(2,11,"Rua dos Super Sayajins","Casa","22222-222","Dragon","Ball","Z");

        //Objeto cliente
        Cliente vegeta = new Cliente("Vegeta","111.111.111-11",vegetaTel, vegetaTel2, vegetaEnd, vegetaEnd2);

        //Dados do Cliente
        vegeta.imprimirCliente();

        //Contatos do cliente Vegeta
        vegeta.imprimirContatos();

        //Endereços do cliente Vegeta
        vegeta.imprimirEnderecos();

        //Objeto Conta Corrente do cliente Vegeta
        ContaCorrente vegetaCC = new ContaCorrente(vegeta,"001","01",10D, 10D);

        //Imprimi dados da Conta Corrente do cliente Vegeta
        vegetaCC.imprimir();

        //Saque invalido
        System.out.println(vegetaCC.sacar(50D));

        //Saque Válido
        System.out.println(vegetaCC.sacar(2D));

        //Mostrando conta após o saque;
        vegetaCC.imprimir();

        //Depósito Invalido
        System.out.println(vegetaCC.depositar(-1));

        //Deposito com Sucesso
        System.out.println(vegetaCC.depositar(3));

        //Constatação do Depósito
        vegetaCC.imprimir();

        /* Conta
        Poupança */

        //Objeto vegetaPoupanca
        ContaPoupanca vegetaPoupanca = new ContaPoupanca(vegeta,"002","02",10D);

        //transferencia de conta corrente para conta poupança
        vegetaCC.transferir(vegetaPoupanca,2);

        //mostra dados após a transferencia
        vegetaCC.imprimir();
        vegetaPoupanca.imprimir();

    }
}
