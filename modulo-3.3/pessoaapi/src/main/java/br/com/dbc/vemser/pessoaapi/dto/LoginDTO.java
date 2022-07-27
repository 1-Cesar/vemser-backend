package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginDTO {

    @Schema(description = "login do usuario", example = "vegeta")
    @NotEmpty
    private String login;

    @Schema(description = "senha do usuario", example = "sayajin")
    @NotEmpty
    private String senha;
}
