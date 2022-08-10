package br.com.dbc.chatkafka.controller;

import br.com.dbc.chatkafka.dto.MensagemCreateDto;
import br.com.dbc.chatkafka.enums.GaleraEnum;
import br.com.dbc.chatkafka.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/kafka-chat")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar-mensagem")
    public void enviarMensagemPrivada(@RequestParam List<GaleraEnum> galeraEnum, @RequestBody MensagemCreateDto mensagemCreateDto) throws JsonProcessingException {
        produtorService.capturandoMensagem(mensagemCreateDto , galeraEnum);
    }
}