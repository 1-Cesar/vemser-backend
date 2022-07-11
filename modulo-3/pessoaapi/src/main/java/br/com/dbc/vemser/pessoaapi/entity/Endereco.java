package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private Integer idPessoa;

    private Integer idEndereco;

    @NotNull(message = "informe o tipo do endereço (RESIDENCIAL ou COMERCIAL)")
    private EnumTipo tipo;

    @NotBlank
    @Size(min = 1, max = 250, message = "máximo 250 caracteres")
    private String logradouro;

    @NotBlank(message = "número deve ser preenchido")
    private String numero;

    private String complemento;

    @NotBlank(message = "CEP obrigatório")
    @Size(min = 8, max = 8, message = "CEP deve contem 8 caracteres")
    private String cep;

    @NotBlank(message = "cidade deve ser preenchida")
    @Size(min = 1, max = 250, message = "cidade deve contem no maximo 250 caracteres")
    private String cidade;

    @NotBlank(message = "Estado deve ser preenchido")
    private String estado;

    @NotBlank(message = "País deve ser preenchido")
    private String pais;
}
