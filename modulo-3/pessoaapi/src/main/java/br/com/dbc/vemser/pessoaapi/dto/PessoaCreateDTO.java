package br.com.dbc.vemser.pessoaapi.dto;

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

    @CPF
    @NotEmpty
    private String cpf;

    @NotBlank
    @Email
    private String email;
}
