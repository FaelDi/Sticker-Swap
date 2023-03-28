package com.ada.album.transacao.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("usuarios")
public interface UsuarioClient {

}