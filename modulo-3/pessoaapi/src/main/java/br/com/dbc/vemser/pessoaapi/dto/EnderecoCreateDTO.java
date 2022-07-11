package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {

    private Integer idPessoa;

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

}
