package com.ada.album.transacao.infrastructure.gateway;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.infrastructure.client.FigurinhaClient;

@SpringBootTest
public class FigurinhaGatewayTest {

    private FigurinhaGateway figurinhaGateway;
    private FigurinhaClient figurinhaClient;

    @BeforeEach
    public void setUp() {
        figurinhaGateway = new FigurinhaGateway();
        figurinhaClient = mock(FigurinhaClient.class);
        figurinhaGateway.figurinhaClient = figurinhaClient;
    }

    @Test
    public void testFindFigurinha() {
        FigurinhaDTO figurinhaDTO = new FigurinhaDTO();
        figurinhaDTO.setId("1");
        figurinhaDTO.setDescricao("Figurinha 1");
        when(figurinhaClient.findFigurinhas("1")).thenReturn(figurinhaDTO);

        FigurinhaDTO result = figurinhaGateway.findFigurinha("1");

        assertNotNull(result);
        assertEquals(figurinhaDTO.getId(), result.getId());
        assertEquals(figurinhaDTO.getDescricao(), result.getDescricao());

        verify(figurinhaClient, times(1)).findFigurinhas("1");
    }

    @Test
    public void testAtualizaFigurinha() {
        FigurinhaDTO figurinhaDTO = new FigurinhaDTO();
        figurinhaDTO.setId("1");
        figurinhaDTO.setDescricao("Figurinha 1");
        when(figurinhaClient.atualizaFigurinha("1", figurinhaDTO)).thenReturn(figurinhaDTO);

        FigurinhaDTO result = figurinhaGateway.atualizaFigurinha("1", figurinhaDTO);

        assertNotNull(result);
        assertEquals(figurinhaDTO.getId(), result.getId());
        assertEquals(figurinhaDTO.getDescricao(), result.getDescricao());

        verify(figurinhaClient, times(1)).atualizaFigurinha("1", figurinhaDTO);
    }
}
