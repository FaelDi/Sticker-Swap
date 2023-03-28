package com.ada.album.transacao.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FigurinhaDTO {

	private Long id;

	private Long tipoAlbumId;

	private Long tipoFigurinhaId;

	private Integer quantidade;

	private AlbumDTO album;

}
