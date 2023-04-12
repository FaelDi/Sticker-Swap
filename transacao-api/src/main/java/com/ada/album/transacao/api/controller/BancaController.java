package com.ada.album.transacao.api.controller;


import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.domain.service.BancaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banca")
@Slf4j
public class BancaController {

    private BancaServiceImpl bancaService;

    public BancaController(BancaServiceImpl bancaService) {
        this.bancaService = bancaService;
    }

    @PostMapping("/gerarColecao")
    public ResponseEntity<List<FigurinhaDTO>> geraColecaoFigurinha(@RequestParam String idColecao, @RequestParam String qnt) {
       return ResponseEntity.ok().body(bancaService.geraColecaoFigurinhas(idColecao,qnt));
    }
}
