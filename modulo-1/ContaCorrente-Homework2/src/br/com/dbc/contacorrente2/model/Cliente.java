package br.com.dbc.contacorrente2.model;

import java.util.Arrays;

public class Cliente {
	
	private String nome, cpf;
	private Contato[] contatos = new Contato[2];
	private Endereco[] enderecos = new Endereco[2];
	
	public Cliente(String nome, String cpf, Contato contato, Contato contato2, Endereco endereco, Endereco endereco2) {
		this.nome = nome;
		this.cpf = cpf;
		this.contatos[0] = contato;
		this.contatos[1] = contato2;
		this.enderecos[0] = endereco;	
		this.enderecos[1] = endereco2;
	}	

	public Cliente() {
		
	}
	
	

	@Override
	public String toString() {
		return nome;
	}

	public void imprimirContatos() {
		for (Contato contato : contatos) {
			System.out.println(contato);
		}
	}	

	public void imprimirEnderecos() {
		for (Endereco endereco : enderecos) {
			System.out.println(endereco);
		}
	}
	
	public void imprimirCliente() {
		System.out.println("Nome do cliente: " + nome + "\nCPF do cliente:" + cpf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Contato[] getContatos() {
		return contatos;
	}

	public void setContatos(Contato[] contatos) {
		this.contatos = contatos;
	}

	public Endereco[] getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco[] enderecos) {
		this.enderecos = enderecos;
	}	

}
