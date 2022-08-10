package br.com.dbc.chatkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDto extends  MensagemCreateDto {

    private String usuario;

    private LocalDateTime dataCriacao;
}
