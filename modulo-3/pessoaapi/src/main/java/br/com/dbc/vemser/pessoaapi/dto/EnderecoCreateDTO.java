package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "RESIDENCIAL OU COMERCIAL")
    @NotNull(message = "informe o tipo do endereço (RESIDENCIAL ou COMERCIAL)")
    private EnumTipo tipo;

    @Schema(example = "Rua...../Avenida....")
    @NotBlank
    @Size(min = 6,max = 250)
    private String logradouro;

    @NotBlank
    private String numero;

    @Schema(example = "Casa, Apto, etc.")
    private String complemento;

    @Schema(example = "CEP com 8 digitos sem pontos ou traços")
    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;

    @NotBlank
    @Size(min = 3,max = 250)
    private String cidade;

    @Schema(example = "SP, RS, etc.")
    @NotBlank
    private String estado;

    @NotBlank
    private String pais;

}
