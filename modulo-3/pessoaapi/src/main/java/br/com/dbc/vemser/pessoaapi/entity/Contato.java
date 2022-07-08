package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.*;

/**
 * @author Cesar
 * @version vemSer - DBC
 */
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

    @NotBlank
    @Size(min = 8, max = 13, message = "número inválido")
    private String numero;

    @NotBlank(message = "Descrição deve ser preencida (ex: whatsapp, telegram, observações, etc.)")
    private String descricao;
    @NotNull(message = "informe o tipo do contato (RESIDENCIAL ou COMERCIAL)")
    private EnumTipo tipoContato;

    public Contato(Integer idContato, Integer idPessoa, String numero, String descricao, EnumTipo tipoContato) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.numero = numero;
        this.descricao = descricao;
        this.tipoContato = tipoContato;
    }

    public Contato() {}

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnumTipo getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(EnumTipo tipoContato) {
        this.tipoContato = tipoContato;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato: " + idContato +
                "Telefone: " + numero +
                ", idPessoa: " + idPessoa +
                ", tipo: " + tipoContato +
                ", descricao: '" + descricao + '\'' +
                '}';
    }
}
