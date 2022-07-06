package br.com.dbc.vemser.pessoaapi.entity;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    private String descricao;

    private EnumTipo tipoContato;

    public Contato(Integer idContato, Integer idPessoa, String descricao, EnumTipo tipoContato) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
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
                ", idPessoa: " + idPessoa +
                ", tipo: " + tipoContato +
                ", descricao: '" + descricao + '\'' +
                '}';
    }
}
