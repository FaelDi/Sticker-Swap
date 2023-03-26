package br.com.d2.figurinha.model.dto;

import br.com.d2.figurinha.model.enumeration.Raridade;

public class FigurinhaFactory {
	
	private FigurinhaFactory() {
	    throw new IllegalStateException("Utility class");
	  }

	public static FigurinhaDTO getFigurinha(Raridade raridade, String descricao, String imagem, String colecao) {
		
		FigurinhaDTO figurinhaDTO = new FigurinhaDTO();
		
		figurinhaDTO.setIdColecao(colecao);
		figurinhaDTO.setDescricao(descricao);
		figurinhaDTO.setImagem(imagem);
		figurinhaDTO.setRaridade(raridade.getId());
		figurinhaDTO.setPreco(raridade.getPreco());
		
		return figurinhaDTO;
		
	}
}
