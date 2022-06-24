package br.com.dbc.contacorrente.main;

import br.com.dbc.contacorrente.main.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        List<Contato> listVegetaTel = new ArrayList<>();
        List<Endereco> listVegetaEnd = new ArrayList<>();

        Contato vegetaTel = new Contato(1,"O Miseravel é um genio","11111-1111");
        Contato vegetaTel2 = new Contato(2,"Kakaroto é meu rival","22222-2222");

        Endereco vegetaEnd = new Endereco(1,10,"Rua dos Sayajins","Apto","11111-111","Dragon","Ball","Z");
        Endereco vegetaEnd2 = new Endereco(2,11,"Rua dos Super Sayajins","Casa","22222-222","Dragon","Ball","Z");

        listVegetaTel.add(vegetaTel);
        listVegetaTel.add(vegetaTel2);
        listVegetaEnd.add(vegetaEnd);
        listVegetaEnd.add(vegetaEnd2);

        //Objeto cliente
        Cliente vegeta = new Cliente("Vegeta","111.111.111-11", listVegetaTel, listVegetaEnd);

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

        /* Conta
        Poupança */

        //Objeto vegetaPoupanca
        ContaPoupanca vegetaPoupanca = new ContaPoupanca(vegeta,"002","02",10D);

        //transferencia de conta corrente para conta poupança
        vegetaCC.transferir(vegetaPoupanca,2);

        //mostra dados após a transferencia
        vegetaCC.imprimir();
        vegetaPoupanca.imprimir();

        //Objeto conta de pagamento
        ContaPagamento contaPagamento = new ContaPagamento(vegeta,"003","01",10);

        List<Contato> listGokuTel = new ArrayList<>();
        List<Endereco> listGokuEnd = new ArrayList<>();

        Contato gokuTel = new Contato(1,"Trabalhe arduamente e nunca deixe de sonhar","11111-1111");
        Contato gokuTel2 = new Contato(2,"Os limites só existem se você os deixar existir","22222-2222");

        Endereco gokuEnd = new Endereco(1,10,"Rua dos Sayajins","Apto","11111-111","Dragon","Ball","Z");
        Endereco gokuEnd2 = new Endereco(2,11,"Rua dos Super Sayajins 3","Casa","22222-222","Dragon","Ball","Z");

        //objeto goku
        Cliente goku = new Cliente("Goku","222.222.222-22", listGokuTel, listGokuEnd);

        //objeto gokupoupanca
        ContaPoupanca gokuPoupanca = new ContaPoupanca(goku,"004","04",10);

        //3 movimentações

        vegetaCC.imprimir();
        gokuPoupanca.imprimir();
        //transferencia de gokuPoupanca para vegetaContaCorrente
        gokuPoupanca.transferir(vegetaCC,1);
        gokuPoupanca.imprimir();
        vegetaCC.imprimir();

        //Saque conta de pagamento
        contaPagamento.imprimir();
        //bloqueio de saque
        contaPagamento.sacar(6);
        //saque de 5 reais
        contaPagamento.sacar(5);
        //imprime dados da conta
        contaPagamento.imprimir();

        //Depósito ContaCorrente
        vegetaCC.imprimir();
        //Depósito Invalido
        System.out.println(vegetaCC.depositar(-1));
        //Deposito com Sucesso
        System.out.println(vegetaCC.depositar(3));
        //Constatação do Depósito
        vegetaCC.imprimir();

    }
}
