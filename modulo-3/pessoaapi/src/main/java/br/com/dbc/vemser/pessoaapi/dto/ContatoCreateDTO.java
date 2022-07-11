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
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotBlank
    @Size(min = 8, max = 13, message = "número inválido")
    private String numero;

    @NotBlank(message = "Descrição deve ser preencida (ex: whatsapp, telegram, observações, etc.)")
    private String descricao;

    @NotNull(message = "informe o tipo do contato (RESIDENCIAL ou COMERCIAL)")
    private EnumTipo tipoContato;

}
