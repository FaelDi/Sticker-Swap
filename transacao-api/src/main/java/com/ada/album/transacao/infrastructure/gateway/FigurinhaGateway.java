package com.ada.album.transacao.infrastructure.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.handle.ErrorException;
import com.ada.album.transacao.infrastructure.client.FigurinhaClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;

@Component
public class FigurinhaGateway {

    @Autowired
    FigurinhaClient figurinhaClient;

    @CircuitBreaker(name = "findFigurinha", fallbackMethod = "findFigurinhaFallback")
    public FigurinhaDTO findFigurinha(String id){
        return figurinhaClient.findFigurinhas(id);
    }

    @CircuitBreaker(name = "atualizaFigurinha", fallbackMethod = "atualizaFigurinhaFallback")
    public FigurinhaDTO atualizaFigurinha(String id, FigurinhaDTO figurinhaDTO){
        return figurinhaClient.atualizaFigurinha(id, figurinhaDTO);
    }

    @CircuitBreaker(name = "geraColecaoFigurinhas", fallbackMethod = "findFigurinhaFallback")
    public List<FigurinhaDTO> geraColecaoFigurinhas(String idColecao, String qnt) {
        return figurinhaClient.geraFigurinhas(idColecao,qnt);
    }

    private FigurinhaDTO findFigurinhaFallback(String id, Throwable e){
        throw new ErrorException( "Figurinhas não disponivel, tente mais tarde");
    }

    private List<FigurinhaDTO> geraColecaoFigurinhasFallback(String idColecao, String qnt, Throwable e){
        throw new ErrorException( "Banca não disponivel, tente mais tarde");
    }

    private FigurinhaDTO atualizaFigurinhaFallback(String id , FigurinhaDTO figurinhaDTO, Throwable e){
        throw new ErrorException("Figurinhas não disponivel, tente mais tarde");
    }
}
