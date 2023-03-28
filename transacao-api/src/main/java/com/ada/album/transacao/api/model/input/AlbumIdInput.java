package com.ada.album.transacao.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlbumIdInput {
	
	@NotNull
	private Long albumId;

}
