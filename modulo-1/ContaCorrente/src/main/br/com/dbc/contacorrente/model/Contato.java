package main.br.com.dbc.contacorrente.model;

public class Contato {
    public String descricao, telefone;
    public int tipo;
    public void imprimirContato() {
        System.out.println("\n--------------------");
        if (tipo == 1) {
            System.out.println("\nTelefone: " + telefone + "\n" +
                                 "Descricao: " + descricao + "\n" +
                                 "Tipo: " + tipo);
        } if (tipo == 2) {
            System.out.println("\nTelefone: " + telefone + "\n" +
                                 "Descricao: " + descricao + "\n" +
                                 "Tipo: " + tipo);
        }
    }
}
