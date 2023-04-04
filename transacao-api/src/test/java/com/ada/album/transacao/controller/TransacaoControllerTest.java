package com.ada.album.transacao.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ada.album.transacao.api.controller.TransacaoController;
import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.api.model.input.TransferenciaFigurinhaInput;
import com.ada.album.transacao.domain.service.TransacaoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransacaoControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TransacaoServiceImpl transacaoService;

    @BeforeEach
    public  void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new TransacaoController(transacaoService)).build();
    }

    @Test
    public void testTransferirSuccess() throws Exception {
        // Monta o objeto de entrada do teste
    	UUID idComprador = UUID.randomUUID();
    	UUID idVendedor = UUID.randomUUID();
    	UUID idFigurinha = UUID.randomUUID();

    	
        TransferenciaFigurinhaInput input = new TransferenciaFigurinhaInput();
        input.setAlbumIdOrigem(idComprador);
        input.setAlbumIdOrigem(idVendedor);
        input.setFigurinhaId(idFigurinha);

        // Monta o objeto de saída do teste
        FigurinhaDTO output = new FigurinhaDTO();
        output.setId(idFigurinha.toString());

        // Configura o mock do serviço de transação
        when(transacaoService.transferir(any())).thenReturn(output);

        assertThat(transacaoService).isNotNull();
    }

    @Test
    public void testTransferirError() throws Exception {
    	
    	UUID idComprador = UUID.randomUUID();
    	UUID idVendedor = UUID.randomUUID();
    	UUID idFigurinha = UUID.randomUUID();
        // Monta o objeto de entrada do teste
        TransferenciaFigurinhaInput input = new TransferenciaFigurinhaInput();
        input.setAlbumIdDestino(idComprador);
        input.setAlbumIdOrigem(idVendedor);
        input.setFigurinhaId(idFigurinha);

        // Configura o mock do serviço de transação para lançar uma exceção
        when(transacaoService.transferir(any())).thenThrow(new RuntimeException("Erro de teste"));

        // Executa o teste
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/transacao/realiza/venda")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(input)))
                .andExpect(status().isBadRequest())
                .andReturn();

        // Verifica se o resultado da requisição é o esperado
        assertEquals("", result.getResponse().getContentAsString());
    }
}
