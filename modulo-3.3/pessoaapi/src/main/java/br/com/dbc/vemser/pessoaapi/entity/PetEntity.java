package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PET")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "seq_pet", allocationSize = 1)
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "ID_PESSOA", insertable = false, updatable = false)
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    @Enumerated(EnumType.ORDINAL)
    private TipoPet tipo;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;
}
