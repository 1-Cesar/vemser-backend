package br.com.dbc.contacorrente2.model;

public class Contato {
	
	private String descricao, telefone;
	//1- residencial, 2-comercial
	private int tipo;
	
	public Contato(int tipo, String descricao, String telefone) {
		this.tipo = tipo;
		this.descricao = descricao;
		this.telefone = telefone;
	}	
	

	@Override
	public String toString() {
		return "Contato [Descricao: " + descricao + ", Telefone: " + telefone + ", Tipo: " + tipo + "]";
	}



	public void imprimirContato() {
		System.out.println("Tipo de telefone: " + tipo + "\nTelefone: " + telefone + "\nDescricao: " + descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}	

}
