package com.ada.album.transacao.domain.service;

import com.ada.album.transacao.api.model.AlbumDTO;
import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.api.model.input.TransferenciaFigurinhaInput;
import com.ada.album.transacao.handle.ErrorException;
import com.ada.album.transacao.infrastructure.gateway.AlbumGateway;
import com.ada.album.transacao.infrastructure.gateway.FigurinhaGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class TransacaoServiceImpl  {

    private AlbumGateway albumGateway;

    private FigurinhaGateway figurinhaGateway;

    public TransacaoServiceImpl(AlbumGateway albumGateway, FigurinhaGateway figurinhaGateway) {
        this.albumGateway = albumGateway;
        this.figurinhaGateway = figurinhaGateway;
    }

    public FigurinhaDTO transferir(TransferenciaFigurinhaInput transferenciaFigurinhaInput) {
            AlbumDTO origem = albumGateway.findAlbum(transferenciaFigurinhaInput.getAlbumIdOrigem());
            AlbumDTO destino = albumGateway.findAlbum(transferenciaFigurinhaInput.getAlbumIdDestino());
            FigurinhaDTO figurinhaDTO = figurinhaGateway.findFigurinha(transferenciaFigurinhaInput.getFigurinhaId().toString());

            if(!origem.getIdentificadorFixo().equals(destino.getIdentificadorFixo())){
                throw new ErrorException("O modelo do album de origem e de destino sao diferentes");
            }

            if(!figurinhaDTO.getIdColecao().equals(origem.getIdentificadorFixo().toString())) {
                throw new ErrorException("Figurinha não pertence ao album de origem");
            }

            figurinhaDTO.setIdColecao(destino.getIdentificador().toString());
            return figurinhaGateway.atualizaFigurinha(figurinhaDTO.getId(),figurinhaDTO);
    }
}
