package br.com.dbc.contacorrente.main.classes;

public class Cliente {
    private String nome, cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Contato contatos, Contato contatos2, Endereco enderecos, Endereco enderecos2) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = contatos;
        this.contatos[1] = contatos2;
        this.enderecos[0] = enderecos;
        this.enderecos[1] = enderecos2;
    }
    @Override
    public String toString() {
        return nome;
    }
    public void imprimirContatos() {
        for (Contato contato:contatos) {
            System.out.println("-----------------------------------");
            contato.imprimirContato();
        }
    }
    public void imprimirEnderecos() {
        for (Endereco endereco:enderecos) {
            System.out.println("-----------------------------------");
            endereco.imprimirEndereco();
        }
    }
    public void imprimirCliente() {
        System.out.println("-----------------------------------" + "\n" +
                           "Nome do Cliente:"  + nome +"\n" +
                           "CPF do Cliente: "  + cpf);
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
