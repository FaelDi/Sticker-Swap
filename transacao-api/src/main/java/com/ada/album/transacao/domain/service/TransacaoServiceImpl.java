package com.ada.album.transacao.domain.service;

import com.ada.album.transacao.api.model.AlbumDTO;
import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.api.model.input.TransferenciaFigurinhaInput;
import com.ada.album.transacao.handle.ErrorException;
import com.ada.album.transacao.infrastructure.gateway.AlbumGateway;
import com.ada.album.transacao.infrastructure.gateway.FigurinhaGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransacaoServiceImpl {

    private AlbumGateway albumGateway;

    private FigurinhaGateway figurinhaGateway;

    private RedisServiceImpl redisService;

    public TransacaoServiceImpl(AlbumGateway albumGateway, FigurinhaGateway figurinhaGateway, RedisServiceImpl redisService) {
        this.albumGateway = albumGateway;
        this.figurinhaGateway = figurinhaGateway;
        this.redisService = redisService;
    }

    public FigurinhaDTO transferir(TransferenciaFigurinhaInput transferenciaFigurinhaInput) {
        AlbumDTO origem = albumGateway.findAlbum(transferenciaFigurinhaInput.getAlbumIdOrigem());
        AlbumDTO destino = albumGateway.findAlbum(transferenciaFigurinhaInput.getAlbumIdDestino());
        FigurinhaDTO figurinhaDTO = figurinhaGateway.findFigurinha(transferenciaFigurinhaInput.getFigurinhaId().toString());

        if (!origem.getIdentificadorFixo().equals(destino.getIdentificadorFixo())) {
            throw new ErrorException("O modelo do album de origem e de destino sao diferentes");
        }

        if (!figurinhaDTO.getIdColecao().equals(origem.getIdentificador().toString())) {
            throw new ErrorException("Figurinha não pertence ao album de origem");
        }

        figurinhaDTO.setIdColecao(destino.getIdentificador().toString());

        String usuarioIdString = origem.getUsuarioId().toString();
        log.info("usuarioId: "+usuarioIdString);
        redisService.save(usuarioIdString,transferenciaFigurinhaInput.getValor().toString());

        //TODO persistir a transação no banco.
        return figurinhaGateway.atualizaFigurinha(figurinhaDTO.getId(), figurinhaDTO);
    }
}
