package com.ada.album.transacao.infrastructure.gateway;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ada.album.transacao.api.model.AlbumDTO;
import com.ada.album.transacao.infrastructure.client.AlbumClient;

public class AlbumGatewayTest {

  @Mock
  private AlbumClient albumClient;

  private AlbumGateway albumGateway;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    albumGateway = new AlbumGateway();
    albumGateway.albumClient = albumClient;
  }

  @Test
  public void findAlbum_returnsAlbumDTO_whenAlbumExists() {
    Long albumId = 1L;
    UUID identificadorAlbum = UUID.randomUUID();
    AlbumDTO albumDTO = new AlbumDTO();
    albumDTO.setId(albumId);
    albumDTO.setIdentificador(identificadorAlbum);

    when(albumClient.findAlbum(any(UUID.class))).thenReturn(albumDTO);

    AlbumDTO result = albumGateway.findAlbum(identificadorAlbum);

    assertThat(result).isNotNull();
    assertThat(result.getId()).isEqualTo(albumId);
  }

}
