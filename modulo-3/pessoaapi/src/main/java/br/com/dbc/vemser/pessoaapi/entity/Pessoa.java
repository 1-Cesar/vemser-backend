package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Integer idPessoa;

    @NotBlank(message = "Nome deve ser preenchido")
    //@Getter(AccessLevel.NONE) -> ignorando get para nome
    private String nome;

    @NotNull(message = "Data de nascimento incorreta")
    @Past(message = "Verifique se digitou corretamente sua data de nascimento")
    private LocalDate dataNascimento;

    @NotBlank
    @CPF
    @Size(min = 11, max = 11, message = "CPF: digite seu CPF sem pontos ou traços")
    private String cpf;

    @NotBlank
    @Email
    private String email;
}
