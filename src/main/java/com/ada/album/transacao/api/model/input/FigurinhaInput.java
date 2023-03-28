package com.ada.album.transacao.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FigurinhaInput {

	@NotNull
	private Long tipoAlbumId;

	@NotNull
	private Long tipoFigurinhaId;

	@Positive
	private Integer quantidade;

	@Valid
	@NotNull
	private Long albumId;

}
