package br.com.dbc.chatkafka.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensagemDto {

    @Schema(hidden = true)
    private String usuario;

    private String mensagem;

    @Schema(hidden = true)
    private LocalDateTime dataCriacao;
}
