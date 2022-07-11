package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;

/**
 * @author Cesar
 * @version vemSer - DBC
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

    @NotBlank
    @Size(min = 8, max = 13, message = "número inválido")
    private String numero;

    @NotBlank(message = "Descrição deve ser preencida (ex: whatsapp, telegram, observações, etc.)")
    private String descricao;

    @NotNull(message = "informe o tipo do contato (RESIDENCIAL ou COMERCIAL)")
    private EnumTipo tipoContato;
}
