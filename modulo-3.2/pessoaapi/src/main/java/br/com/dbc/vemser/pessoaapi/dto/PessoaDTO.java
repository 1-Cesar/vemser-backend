package br.com.dbc.vemser.pessoaapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaDTO extends PessoaCreateDTO {

    @Schema(description = "id da pessoa", example = "1")
    private Integer idPessoa;

}
