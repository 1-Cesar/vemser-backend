package br.com.dbc.contacorrente.main.classes;

import java.util.Collections;
import java.util.List;

public class Cliente {
    private String nome, cpf;
    private List<Contato> contatos;
    private List<Endereco> enderecos;

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Cliente(String nome, String cpf, List<Contato> contatos, List<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return nome;
    }
    public void imprimirContatos() {
        if (contatos != null && contatos.size() > 0) {
            System.out.println("-----------------------------------");
            for (Contato i:contatos) {
                i.imprimirContato();
            }
        }
    }

    public void imprimirEnderecos() {
        if (enderecos != null && enderecos.size() > 0) {
            System.out.println("-----------------------------------");
            for (Endereco i:enderecos) {
                i.imprimirEndereco();
            }
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

    /*public Contato[] getContatos() {
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
    }*/
}
