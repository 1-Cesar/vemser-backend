package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Endereco {

    private Integer idPessoa;

    private Integer idEndereco;

    @NotNull(message = "informe o tipo do endereço (RESIDENCIAL ou COMERCIAL)")
    private EnumTipo tipo;

    @NotBlank
    @Size(max = 250)
    private String logradouro;

    @NotBlank
    private String numero;
    private String complemento;

    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;

    @NotBlank
    @Size(max = 250)
    private String cidade;

    @NotBlank
    private String estado;

    @NotBlank
    private String pais;

    public Endereco(Integer idPessoa, Integer idEndereco, EnumTipo tipo, String logradouro, String numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idPessoa = idPessoa;
        this.idEndereco = idEndereco;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Endereco() {}

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public EnumTipo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipo tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
