package com.ada.album.transacao.infrastructure.client;

import com.ada.album.transacao.api.model.FigurinhaDTO;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient("figurinhas")
public interface FigurinhaClient {

    @GetMapping("/figurinhas/{id}")
    FigurinhaDTO findFigurinhas(@PathVariable String id);

    @PutMapping("/figurinhas/{id}")
    FigurinhaDTO atualizaFigurinha(@PathVariable String id, @RequestBody @Valid FigurinhaDTO figurinhaDTO);

    @PostMapping("/figurinhas/geraColecao")
    List<FigurinhaDTO> geraFigurinhas(@RequestParam String idColecao, @RequestParam String qnt);

}
