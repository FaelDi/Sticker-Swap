package com.ada.album.transacao.api.controller;

import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.api.model.input.TransferenciaFigurinhaInput;
import com.ada.album.transacao.domain.service.TransacaoServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
@Slf4j
public class TransacaoController {

    private TransacaoServiceImpl transacaoService;

    public TransacaoController(TransacaoServiceImpl transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/realiza/venda")
    public ResponseEntity<FigurinhaDTO> transferir(@RequestBody @Valid TransferenciaFigurinhaInput transferenciaFigurinhaInput) {

        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(transacaoService.transferir(transferenciaFigurinhaInput));

        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
