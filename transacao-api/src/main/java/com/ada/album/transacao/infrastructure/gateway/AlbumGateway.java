package com.ada.album.transacao.infrastructure.gateway;

import com.ada.album.transacao.api.model.AlbumDTO;
import com.ada.album.transacao.handle.ErrorException;
import com.ada.album.transacao.infrastructure.client.AlbumClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Component
public class AlbumGateway {

    @Autowired
    AlbumClient albumClient;

    @CircuitBreaker(name = "findAlbum", fallbackMethod = "findAlbumFallback")
    public AlbumDTO findAlbum(UUID id){
        return albumClient.findAlbum(id);
    }

    private AlbumDTO findAlbumFallback(UUID id, Throwable e){
        throw new ErrorException("Album não disponivel, tente mais tarde");
    }

}
