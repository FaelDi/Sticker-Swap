package com.ada.album.transacao.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AlbumDTO {

	private Long id;

	private UUID usuarioId;
	private UUID identificador;
	
	private UUID identificadorFixo;
	
	private String titulo;
	
	private String descricao;

}
