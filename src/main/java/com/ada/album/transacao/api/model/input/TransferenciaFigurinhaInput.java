package com.ada.album.transacao.api.model.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaFigurinhaInput {
	
	@NotNull
	private Long albumIdOrigem;
	
	@NotNull
	private Long albumIdDestino;
	
	@NotNull
	private Long figurinhaId;
	
	@Positive
	private Integer quantidade;

}
