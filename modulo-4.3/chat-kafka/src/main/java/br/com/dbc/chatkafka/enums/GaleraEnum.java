package br.com.dbc.chatkafka.enums;

import java.util.Arrays;

public enum GaleraEnum {

    GERAL("chat-geral"),
    BRUNO("chat-bruno"),
    CASTRO("chat-castro"),
    CLEBER("chat-cleber"),
    DAYVIDSON("chat-dayvidson"),
    GABRIEL("chat-gabriel"),
    JEAN("chat-jean"),
    MACHADO("chat-machado"),
    PAULO("chat-paulo"),
    RAFAEL("chat-rafael"),
    RODRIGO("chat-rodrigo"),
    WILLIAN("chat-willian");

    private String chat;

    GaleraEnum(String chat){
        this.chat = chat;
    }

    public String getChat(){return chat;}

    public static GaleraEnum ofTipo(String chat){
        return Arrays.stream(GaleraEnum.values())
                .filter(tp -> tp.getChat().equals(chat))
                .findFirst()
                .get();
    }
}
