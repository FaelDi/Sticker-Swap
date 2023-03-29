package com.ada.album.transacao.infrastructure.client;

import com.ada.album.transacao.api.model.AlbumDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient("album-api")
public interface AlbumClient {
    @GetMapping("/albuns/{id}")
    AlbumDTO findAlbum(@PathVariable UUID id);
}