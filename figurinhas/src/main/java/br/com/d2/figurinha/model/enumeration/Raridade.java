package br.com.d2.figurinha.model.enumeration;

public enum Raridade {

	GRAU_1("1", "Raridade 1", "3.50"),
	GRAU_2("2", "Raridade 2", "2.50"),
	GRAU_3("3", "Raridade 3", "2.00"),
	GRAU_4("4", "Raridade 4", "1.50");
	
	private String id;
	private String descicao;
	private String preco;
	
	private Raridade(String id,String descicao, String preco) {
		this.id = id;
		this.descicao = descicao;
		this.preco = preco;
	}
	
	public String getId() {
		return id;
	}

	public String getDescicao() {
		return descicao;
	}
	
	public String getPreco() {
		return preco;
	}

}
