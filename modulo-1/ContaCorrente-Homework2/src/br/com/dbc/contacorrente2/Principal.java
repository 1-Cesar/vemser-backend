package br.com.dbc.contacorrente2;

import br.com.dbc.contacorrente2.model.Cliente;
import br.com.dbc.contacorrente2.model.ContaCorrente;
import br.com.dbc.contacorrente2.model.ContaPoupanca;
import br.com.dbc.contacorrente2.model.Contato;
import br.com.dbc.contacorrente2.model.Endereco;

public class Principal {

	public static void main(String[] args) {
		
		Contato contatoCliente = new Contato(1, "Telefone do Robozao", "111222");
		
        Contato contatoCliente2 = new Contato(2, "Telefone Comercial do Robozao", "222111");
        
        Endereco enderecoCliente = new Endereco(1, 7, "Rua da Champions",
                "Casa", "111222", "Champions League", "Champions", "Portugal");
        
        Endereco enderecoCliente2 = new Endereco(2, 7, "Rua Real",
                "Galpao", "222111", "League", "League League", "Portugal 10");
        
        Cliente cliente = new Cliente("Cristiano Ronaldo", "999888", contatoCliente,
                contatoCliente2, enderecoCliente, enderecoCliente2);

        ContaCorrente contaClienteCorrente = new ContaCorrente(cliente, "7", "8", 10D, 10D);        
        
        ContaPoupanca clientePoupanca = new ContaPoupanca(cliente, "10", "11", 10D);
        
        cliente.imprimirCliente();
        cliente.imprimirContatos();
        cliente.imprimirEnderecos();
        
        System.out.println(" ");
        
        contaClienteCorrente.imprimir();
        contaClienteCorrente.depositar(10);
        contaClienteCorrente.depositar(0);
        contaClienteCorrente.sacar(1300D);
        contaClienteCorrente.sacar(5000D);
        clientePoupanca.imprimir();
        contaClienteCorrente.transferir(clientePoupanca, 10);
        contaClienteCorrente.imprimir();
        clientePoupanca.imprimir();       

	}

}
