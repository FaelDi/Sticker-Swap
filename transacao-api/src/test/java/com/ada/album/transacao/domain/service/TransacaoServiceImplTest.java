package com.ada.album.transacao.domain.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ada.album.transacao.api.model.AlbumDTO;
import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.api.model.input.TransferenciaFigurinhaInput;
import com.ada.album.transacao.infrastructure.gateway.AlbumGateway;
import com.ada.album.transacao.infrastructure.gateway.FigurinhaGateway;

public class TransacaoServiceImplTest {

    private TransacaoServiceImpl transacaoService;

    @Mock
    private AlbumGateway albumGateway;

    @Mock
    private FigurinhaGateway figurinhaGateway;

    @Mock
    private RedisServiceImpl redisService;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
        transacaoService = new TransacaoServiceImpl(albumGateway, figurinhaGateway,redisService);
    }

    @Test
    public void testTransferir() {
        // Configuração
    	UUID albumOrigemId = UUID.randomUUID();
    	UUID albumDestinoId = UUID.randomUUID();
    	UUID figurinhaId = UUID.randomUUID();
        TransferenciaFigurinhaInput transferenciaFigurinhaInput = new TransferenciaFigurinhaInput();
        transferenciaFigurinhaInput.setFigurinhaId(figurinhaId);
        transferenciaFigurinhaInput.setAlbumIdOrigem(albumOrigemId);
        transferenciaFigurinhaInput.setAlbumIdDestino(albumDestinoId);
        
        AlbumDTO origem = new AlbumDTO();
        origem.setIdentificadorFixo(albumOrigemId);
        origem.setIdentificador(albumOrigemId);
        AlbumDTO destino = new AlbumDTO();
        destino.setIdentificadorFixo(albumOrigemId);
        destino.setIdentificador(albumDestinoId);
        FigurinhaDTO figurinhaDTO = new FigurinhaDTO();
        figurinhaDTO.setId(figurinhaId.toString());
        figurinhaDTO.setIdColecao(origem.getIdentificadorFixo().toString());

        when(albumGateway.findAlbum(albumOrigemId)).thenReturn(origem);
        when(albumGateway.findAlbum(albumDestinoId)).thenReturn(destino);
        when(figurinhaGateway.findFigurinha(figurinhaId.toString())).thenReturn(figurinhaDTO);
        when(figurinhaGateway.atualizaFigurinha(figurinhaId.toString(), figurinhaDTO)).thenReturn(figurinhaDTO);

        // Execução
        FigurinhaDTO resultado = transacaoService.transferir(transferenciaFigurinhaInput);

        // Verificação
        verify(albumGateway, times(2)).findAlbum(any());
        verify(figurinhaGateway, times(1)).findFigurinha(anyString());
        verify(figurinhaGateway, times(1)).atualizaFigurinha(any(), any(FigurinhaDTO.class));
        assertEquals(resultado.getIdColecao(), destino.getIdentificador().toString());
    }

}
