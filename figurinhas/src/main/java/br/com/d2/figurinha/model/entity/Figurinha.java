package br.com.d2.figurinha.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Figurinha {
	
	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private String id;
	
	@Column(name="idColecao", nullable=false)
	private String idColecao;

	@Column(name="imagem", nullable = false)
	private String imagem;

	@Column(name="descricao", nullable=true)
	private String descricao;

	@Column(name="raridade", nullable=false)
	private String raridade;

	@Column(name="preco", nullable=false)
	private String preco;

}
