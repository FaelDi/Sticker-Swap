package com.ada.album.transacao.infrastructure.client;

import com.ada.album.transacao.api.model.AlbumDTO;
import com.ada.album.transacao.api.model.FigurinhaDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient("figurinhas")
public interface FigurinhaClient {

    @GetMapping("/figurinhas/{id}")
    FigurinhaDTO findFigurinhas(@PathVariable String id);

    @PutMapping("/figurinhas/{id}")
    FigurinhaDTO atualizaFigurinha(@PathVariable String id, @RequestBody @Valid FigurinhaDTO figurinhaDTO);
}
