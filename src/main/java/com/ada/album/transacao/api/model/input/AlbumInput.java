package com.ada.album.transacao.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumInput {

	@NotNull
	private Long albumId;

	@NotNull
	private Long figurinhaId;
	
}
