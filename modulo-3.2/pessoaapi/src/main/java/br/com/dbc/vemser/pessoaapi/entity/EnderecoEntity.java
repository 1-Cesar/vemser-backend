package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco_contato", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;

    @Column(name = "TIPO")
    private EnumTipo tipo;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "PAIS")
    private String pais;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_ENDERECO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PESSOA"))
    private List<PessoaEntity> pessoas;
}
