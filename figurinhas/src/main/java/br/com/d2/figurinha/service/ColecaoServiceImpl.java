package br.com.d2.figurinha.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.d2.figurinha.model.dto.ColecaoDTO;
import br.com.d2.figurinha.model.dto.FigurinhaDTO;
import br.com.d2.figurinha.model.dto.FigurinhaFactory;
import br.com.d2.figurinha.model.entity.Figurinha;
import br.com.d2.figurinha.model.enumeration.Raridade;
import br.com.d2.figurinha.model.mapper.FigurinhaMapper;
import br.com.d2.figurinha.repository.FigurinhaRepository;

@Service
public class ColecaoServiceImpl implements ColecaoService {
	
	private FigurinhaRepository repository;

	private FigurinhaMapper mapper;
	
	
	public ColecaoServiceImpl(FigurinhaRepository repository, FigurinhaMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	
	@Override
	public List<FigurinhaDTO> getColecao(String idColecao, String qtd) {
		return mapper.parseListDTO(repository.getPacoteFigurinha(idColecao, qtd));
	}
	

	@Override
	public List<FigurinhaDTO> criarColecao(ColecaoDTO colecao) {
		
		String idColecao = colecao.getIdColecao();
		
		List<Figurinha> listEntity = null;
		if(repository.getVerificaExistenciaColecao(idColecao) > 0) {
			listEntity = repository.findAllByIdColecao(idColecao);
		}else {
			listEntity = criarNovaColecao(idColecao);
		}
		
		return mapper.parseListDTO(listEntity);
		
	}
	
	private List<Figurinha> criarNovaColecao(String idColecao) {
		List<FigurinhaDTO> lista = new ArrayList<>(20);

		repository.getPacoteFigurinha(idColecao, "3");

		lista.addAll(criarFigurinhas(idColecao, Raridade.GRAU_4, 10));
		lista.addAll(criarFigurinhas(idColecao, Raridade.GRAU_3, 6));
		lista.addAll(criarFigurinhas(idColecao, Raridade.GRAU_2, 3));
		lista.addAll(criarFigurinhas(idColecao, Raridade.GRAU_1, 1));

		List<Figurinha> entityList = mapper.parseListEntity(lista);

		return repository.saveAll(entityList);
	}
	
	private List<FigurinhaDTO> criarFigurinhas(String idColecao, Raridade raridade, int quantidade){
		
		List<FigurinhaDTO> lista = new ArrayList<>(quantidade);
		for (int i = 0; i < quantidade; i++) {
			lista.add(FigurinhaFactory.getFigurinha(raridade, "descrição "+raridade.getDescicao() , "imagem", idColecao));
		}
		
		return lista;
	}


}
