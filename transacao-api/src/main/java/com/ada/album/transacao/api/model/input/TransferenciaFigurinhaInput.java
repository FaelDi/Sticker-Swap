package com.ada.album.transacao.api.model.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TransferenciaFigurinhaInput {
	
	@NotNull
	private UUID albumIdOrigem;
	
	@NotNull
	private UUID albumIdDestino;
	
	@NotNull
	private UUID figurinhaId;
	
	@Positive
	private Integer quantidade;

	@Positive
	private Double valor;

}
