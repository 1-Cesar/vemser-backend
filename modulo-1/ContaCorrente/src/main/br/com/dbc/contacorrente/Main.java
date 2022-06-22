package main.br.com.dbc.contacorrente;

import main.br.com.dbc.contacorrente.model.Cliente;
import main.br.com.dbc.contacorrente.model.ContaCorrente;
import main.br.com.dbc.contacorrente.model.Contato;
import main.br.com.dbc.contacorrente.model.Endereco;

public class Main {
    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("|                                            |");
        System.out.println("|            DBC Conta-Corrente              |");
        System.out.println("|                                            |");
        System.out.println("==============================================");
        System.out.println("");

        //Cliente 1

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Cristiano Ronaldo";
        cliente1.cpf = "123456789";

        Contato clienteCont = new Contato();
        clienteCont.tipo = 1;
        clienteCont.descricao = "Telefone do Robozao";
        clienteCont.telefone = "123456";
        cliente1.contatos[0] = clienteCont;

        Contato clienteCont2 = new Contato();
        clienteCont2.tipo = 2;
        clienteCont2.descricao = "Telefone Comercial do Robozao";
        clienteCont2.telefone = "123456789";
        cliente1.contatos[1] = clienteCont2;

        Endereco clienteEnd = new Endereco();

        clienteEnd.tipo = 1;
        clienteEnd.numero = 10;
        clienteEnd.logradouro = "Rua da Champions";
        clienteEnd.complemento = "Casa";
        clienteEnd.cep = "12345678";
        clienteEnd.cidade = "Cidade da Champions";
        clienteEnd.estado = "Estado da Champions";
        clienteEnd.pais = "País da Champions";
        cliente1.enderecos[0] = clienteEnd;

        Endereco clienteEnd2 = new Endereco();

        clienteEnd2.tipo = 2;
        clienteEnd2.numero = 11;
        clienteEnd2.logradouro = "Rua de Portugal";
        clienteEnd2.complemento = "Apto";
        clienteEnd2.cep = "87654321";
        clienteEnd2.cidade = "Cidade de Portugal";
        clienteEnd2.estado = "Estado de Portugal";
        clienteEnd2.pais = "Portugol - VisualG";
        cliente1.enderecos[1] = clienteEnd2;

        //populando conta corrente cliente 1
        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.cliente = cliente1;
        contaCorrente1.numeroConta = "07";
        contaCorrente1.agencia = 7;
        contaCorrente1.saldo = 10D;
        contaCorrente1.chequeEspecial = 10D;

        //imprime dados do cliente 1
        cliente1.imprimirCliente();
        System.out.println("\nContatos\nTipo 1 -> Residential / Tipo 2 -> Comercial");
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();

        //Cliente 2

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Messi";
        cliente2.cpf = "987654321";

        Contato cliente2Cont = new Contato();
        clienteCont.tipo = 1;
        clienteCont.descricao = "Telefone do Messi";
        clienteCont.telefone = "654321";
        cliente2.contatos[0] = clienteCont;

        Contato cliente2Cont2 = new Contato();
        clienteCont2.tipo = 2;
        clienteCont2.descricao = "Telefone Comercial do Messi";
        clienteCont2.telefone = "987654321";
        cliente2.contatos[1] = clienteCont2;

        Endereco cliente2End = new Endereco();

        clienteEnd.tipo = 1;
        clienteEnd.numero = 11;
        clienteEnd.logradouro = "Rua da Argentina";
        clienteEnd.complemento = "Casa";
        clienteEnd.cep = "87654321";
        clienteEnd.cidade = "Cidade da Argentina";
        clienteEnd.estado = "Estado da Argentina";
        clienteEnd.pais = "Argentina";
        cliente2.enderecos[0] = clienteEnd;

        Endereco cliente2End2 = new Endereco();

        clienteEnd2.tipo = 2;
        clienteEnd2.numero = 11;
        clienteEnd2.logradouro = "Rua de Manchester";
        clienteEnd2.complemento = "Apto";
        clienteEnd2.cep = "87654321";
        clienteEnd2.cidade = "Cidade de Manchester";
        clienteEnd2.estado = "Estado de Manchester";
        clienteEnd2.pais = "Argentinol";
        cliente2.enderecos[1] = clienteEnd2;

        //populando conta corrente cliente 2
        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.cliente = cliente2;
        contaCorrente2.numeroConta = "010";
        contaCorrente2.agencia = 10;
        contaCorrente2.saldo = 10D;
        contaCorrente2.chequeEspecial = 10D;

        //imprime dados do cliente 2
        cliente2.imprimirCliente();
        System.out.println("\nContatos\nTipo 1 -> Residential / Tipo 2 -> Comercial");
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();

        System.out.println("\ntransações das contas-correntes");

        System.out.println("\n(cliente 1) imprime dados da conta corrente");
        contaCorrente1.imprimirContaCorrente();

        System.out.println("\ncliente 1 deposito de 1 real");
        contaCorrente1.depositar(1D);

        System.out.println("\n(cliente 1) retorna false pois, o saque é maior do que o saldo");
        System.out.println(contaCorrente1.sacar(99D));

        System.out.println("\n(cliente 1) permite sacar 7 ficando 4 na conta");
        System.out.println(contaCorrente1.sacar(7D));

        System.out.println("\n(cliente 2) imprime dados da conta corrente");
        contaCorrente2.imprimirContaCorrente();

        //-----------------------------------------------------------------

        System.out.println("\ncliente 2 deposito de 1 real");
        contaCorrente2.depositar(1D);

        System.out.println("\n(cliente 2) retorna false pois, o saque é maior do que o saldo");
        System.out.println(contaCorrente2.sacar(100D));

        System.out.println("\n(cliente 2) permite sacar 7 ficando 4 na conta");
        System.out.println(contaCorrente2.sacar(7D));

        System.out.println("\ntranferencia entre cliente 1 e cliente 2");

        //divisão de linha
        System.out.println("********");

        System.out.println("\ncliente 1 efetua transferencia de 1 real para o cliente 2");
        System.out.println(contaCorrente1.transferir(contaCorrente2, 1D));

        System.out.println("\nconstatando a transferencia");
        contaCorrente1.imprimirContaCorrente();
        contaCorrente2.imprimirContaCorrente();

        System.out.println("\ncliente 2 efetua transferencia de 1 reais para o cliente 1");
        System.out.println(contaCorrente2.transferir(contaCorrente1, 1D));

        System.out.println("\nconstatando a transferencia 2");
        contaCorrente2.imprimirContaCorrente();
        contaCorrente1.imprimirContaCorrente();

        System.out.println("\nDados finais de cliente 1 e cliente 2 e saldo + cheque especial");
        contaCorrente1.imprimirContaCorrente();
        System.out.println("Cheque Especial + Saldo: " + contaCorrente1.retornarSaldoComChequeEspecial());
        contaCorrente2.imprimirContaCorrente();
        System.out.println("Cheque Especial + Saldo: " + contaCorrente2.retornarSaldoComChequeEspecial());
    }
}
