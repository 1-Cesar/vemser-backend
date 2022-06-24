package br.com.dbc.contacorrente.main.classes;

public class Contato {
    //tipo 1- residencial, 2-comercial
    private int tipo;
    private String descricao, telefone;

    public Contato(int tipo, String descricao, String telefone) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.telefone = telefone;
    }
    public void imprimirContato() {
        System.out.println("Tipo de Telefone: " + tipo + "\n" +
                           "Telefone: "         + telefone + "\n" +
                           "Descricao: "        + descricao);
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
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
}
