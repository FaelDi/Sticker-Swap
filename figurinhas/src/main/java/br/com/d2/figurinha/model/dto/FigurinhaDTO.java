package br.com.d2.figurinha.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FigurinhaDTO {

	private String id;
	private String idColecao;
	private String imagem;
	private String descricao;
	private String raridade;
	private String preco;
}
