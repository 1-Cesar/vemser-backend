package br.com.dbc.chatkafka.service;

import br.com.dbc.chatkafka.dto.MensagemDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumidorService {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.chat-geral}",
            groupId = "${kafka.user}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "chat-geral"
    )
    public void consumir(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDto mensagemDto = objectMapper.readValue(mensagem, MensagemDto.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        log.info(">>>>>>{consume} offset -> '{}' key -> '{}' -> Mensagem -> {} [{}]:{} ", offset, key, mensagemDto.getDataCriacao().format(formatter), mensagemDto.getUsuario(), mensagemDto.getMensagem());
    }

    @KafkaListener(
            topics = "${kafka.chat-cesar}",
            groupId = "${kafka.user}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "chat-privado"
    )
    public void consumirPrivado(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDto mensagemDto = objectMapper.readValue(mensagem, MensagemDto.class);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        log.info(">>>>>>{consume} offset -> '{}' key -> '{}' -> Mensagem -> {} [{}](privado):{} ", offset, key, mensagemDto.getDataCriacao().format(formatter), mensagemDto.getUsuario(), mensagemDto.getMensagem());
    }
}
