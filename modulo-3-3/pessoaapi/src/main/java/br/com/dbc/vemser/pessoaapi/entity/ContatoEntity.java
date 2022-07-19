package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author Cesar
 * @version vemSer - DBC
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
    @SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;

    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "TIPO")
    private EnumTipo tipoContato;
}
