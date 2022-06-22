package main.br.com.dbc.contacorrente.model;

public class Cliente {
    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];
    public void imprimirContatos() {
        for (int i = 0; i < contatos.length; i++) {
            contatos[i].imprimirContato();
        }
    }
    public void imprimirEnderecos() {
        for (int i = 0; i < enderecos.length; i++) {
            enderecos[i].imprimirEndereco();
        }
    }
    public void imprimirCliente() {
        System.out.println("\nNome do Cliente: " + nome + " | CPF: " + cpf);
    }
}
