package com.ada.album.transacao.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessageDTO {

    int code;
    String message;

    public MessageDTO(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
