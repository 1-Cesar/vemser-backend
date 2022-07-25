package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCompletaDTO extends PessoaDTO {

    private List<ContatoDTO> contatoDTOS;
    private List<EnderecoDTO> enderecoDTOS;
    private PetDTO petDTO;
}
