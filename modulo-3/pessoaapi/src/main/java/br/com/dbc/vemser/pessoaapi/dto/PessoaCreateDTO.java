package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {

    @NotEmpty
    private String nome;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @Schema(example = "cpf sem pontos ou traços")
    @CPF
    @NotEmpty
    private String cpf;

    @Schema(example = "email@email.com.br")
    @NotBlank
    @Email
    private String email;
}
