package com.ada.album.transacao.domain.service;

import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.infrastructure.gateway.FigurinhaGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancaServiceImpl {

    private FigurinhaGateway figurinhaGateway;

    public BancaServiceImpl(FigurinhaGateway figurinhaGateway) {
        this.figurinhaGateway = figurinhaGateway;
    }

    public List<FigurinhaDTO> geraColecaoFigurinhas(String idColecao, String qtd) {
        return figurinhaGateway.geraColecaoFigurinhas(idColecao,qtd);
    }
}
