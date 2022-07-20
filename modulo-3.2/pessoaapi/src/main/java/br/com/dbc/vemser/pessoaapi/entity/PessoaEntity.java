package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PESSOA")
public class PessoaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    //@Getter(AccessLevel.NONE) -> ignorando get para nome
    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

//    @Column(name = "ID_PET")
//    private Integer idPet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pessoa",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO",
                joinColumns = @JoinColumn(name = "ID_PESSOA"),
                inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    private List<EnderecoEntity> enderecos;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PetEntity pet;
}
