package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCompletaDTO {

    private Integer idPessoa;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String petNome;
    private TipoPet tipoPet;
    private String numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String logradouro;
    private EnumTipo tipo;
    private String numeroContato;
    private EnumTipo tipoContato;
    private String descricao;
}
