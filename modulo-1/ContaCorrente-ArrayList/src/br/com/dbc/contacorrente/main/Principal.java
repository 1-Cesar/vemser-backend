package br.com.dbc.contacorrente.main;

import br.com.dbc.contacorrente.main.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {

        //Primeiro Cliente

        List<Contato> listVegetaTel = new ArrayList<>();
        List<Endereco> listVegetaEnd = new ArrayList<>();

        Contato vegetaTel = new Contato(1,"telefone do vegeta","11111-1111");
        Contato vegetaTel2 = new Contato(2,"telefone do vegeta 2","22222-22222");

        Endereco vegetaEnd = new Endereco(1,10,"Rua dos Sayajins","Apto","11111-111","Dragon","Ball","Z");
        Endereco vegetaEnd2 = new Endereco(2,12,"Rua dos Sayajins2","Casa","22222-222","Dragon","Ball","Z");

        //Adicionando dados na lista

        listVegetaTel.add(vegetaTel);
        listVegetaTel.add(vegetaTel2);
        listVegetaEnd.add(vegetaEnd);
        listVegetaEnd.add(vegetaEnd2);


        //Objeto cliente
        Cliente vegeta = new Cliente("Vegeta","111.111.111-11", listVegetaTel, listVegetaEnd);

        //Dados do 1º cliente
        System.out.println("\nDados do 1º Cliente");
        vegeta.imprimirCliente();

        //Contatos do do 1º cliente
        System.out.println("\nContatos do 1º cliente");
        vegeta.imprimirContatos();

        //Endereços do cliente Vegeta
        System.out.println("\nEndereços do 1º cliente");
        vegeta.imprimirEnderecos();

        //Objeto Conta Corrente do cliente Vegeta
        ContaCorrente vegetaCC = new ContaCorrente(vegeta,"001","01",10D, 10D);

        //Imprimi dados da Conta Corrente do cliente Vegeta
        System.out.println("\nConta Corrente do 1º cliente com saldo de 10 e chequeEspecial 10");
        vegetaCC.imprimir();

        /* Conta
        Pagamento */

        //Objeto vegetaPoupanca
        ContaPagamento vegetaPagamento = new ContaPagamento(vegeta,"002","02",10D);

        System.out.println("\nMostrando dados da Conta de Pagamento");
        vegetaPagamento.imprimir();

        //transferencia de conta corrente para conta de pagamento
        System.out.println("\nTransferência de 2 da Conta Corrente (que atualmente tem 10) para Conta de Pagamento que tem 10 (taxa desconsiderada na transferencia)");
        vegetaCC.transferir(vegetaPagamento,2);

        //mostra dados após a transferencia
        System.out.println("\nMostrando dados da CC e CP após a transferência");
        vegetaCC.imprimir();
        vegetaPagamento.imprimir();

        /*//Objeto conta de pagamento
        ContaPagamento contaPagamento = new ContaPagamento(vegeta,"003","01",10);*/

        List<Contato> listGokuTel = new ArrayList<>();
        List<Endereco> listGokuEnd = new ArrayList<>();

        Contato gokuTel = new Contato(1,"Trabalhe arduamente e nunca deixe de sonhar","11111-1111");
        Contato gokuTel2 = new Contato(2,"Os limites só existem se você os deixar existir","22222-2222");

        Endereco gokuEnd = new Endereco(1,10,"Rua dos Sayajins","Apto","11111-111","Dragon","Ball","Z");
        Endereco gokuEnd2 = new Endereco(2,11,"Rua dos Super Sayajins 3","Casa","22222-222","Dragon","Ball","Z");

        //objeto goku
        Cliente goku = new Cliente("Goku","222.222.222-22", listGokuTel, listGokuEnd);

        ContaPoupanca gokuPoupanca = new ContaPoupanca(goku,"004","04",20);

        System.out.println("\nMostrando Conta Corrente Cliente 1 e Conta Poupança Cliente 2");
        vegetaCC.imprimir();
        gokuPoupanca.imprimir();

        System.out.println("\nTransferencia de 10 da Conta Poupança para Conta Corrente (taxa de saque desconsiderada na transferencia)");
        //transferencia de gokuPoupanca para vegetaContaCorrente
        gokuPoupanca.transferir(vegetaCC,10);

        System.out.println("\nConstatando Transferência");
        gokuPoupanca.imprimir();
        vegetaCC.imprimir();


        System.out.println("\nMostrando Conta Corrente Cliente 1 e Conta Poupança Cliente 2");
        vegetaCC.imprimir();
        gokuPoupanca.imprimir();

        System.out.println("\nTransferencia de 10 da Conta Corrente para Conta Poupança (taxa de saque desconsiderada)");
        //transferencia de gokuPoupanca para vegetaContaCorrente
        vegetaCC.transferir(gokuPoupanca,10);

        System.out.println("\nConstatando transferência");
        gokuPoupanca.imprimir();
        vegetaCC.imprimir();

        System.out.println("\nMostrando dados da conta de pagamento");
        //Saque conta de pagamento
        vegetaPagamento.imprimir();

        System.out.println("\nBloqueando saque inválido de 8 (por existir taxa de saque e a conta não pode ficar negativa)");
        //bloqueio de saque
        vegetaPagamento.sacar(8);

        System.out.println("\nPermitindo saque de 5");
        //saque de 5 reais
        vegetaPagamento.sacar(7);

        System.out.println("\nConstatando atualizações na Conta de Pagamento");
        //imprime dados da conta
        vegetaPagamento.imprimir();

        System.out.println("\nDepósito em conta corrente");
        //Depósito ContaCorrente
        vegetaCC.imprimir();

        System.out.println("\nDepósito inválido com valor negativo");
        //Depósito Invalido
        System.out.println(vegetaCC.depositar(-1));

        System.out.println("\nDepósito válido de 3");
        //Deposito com Sucesso
        System.out.println(vegetaCC.depositar(3));

        System.out.println("\nConstatação do depósito");
        //Constatação do Depósito
        vegetaCC.imprimir();

        vegetaPagamento.depositar(50D);

        vegetaPagamento.imprimir();

        vegetaPagamento.transferir(vegetaCC, 2D);

        vegetaPagamento.imprimir();
    }
}
