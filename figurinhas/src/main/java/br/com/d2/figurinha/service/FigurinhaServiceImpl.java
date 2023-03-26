package br.com.d2.figurinha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.d2.figurinha.model.dto.FigurinhaDTO;
import br.com.d2.figurinha.model.entity.Figurinha;
import br.com.d2.figurinha.model.mapper.FigurinhaMapper;
import br.com.d2.figurinha.repository.FigurinhaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FigurinhaServiceImpl implements FigurinhaService {

	@Autowired
	private FigurinhaRepository repository;

	@Autowired
	private FigurinhaMapper mapper;

	public List<FigurinhaDTO> buscarTodos() {
		return mapper.parseListDTO(repository.findAll());
	}

	public FigurinhaDTO buscarUm(String id) {
		Optional<Figurinha> figurinhaOp = repository.findById(id);
		if (figurinhaOp.isPresent()) {
			Figurinha figurinha = figurinhaOp.get();
			return mapper.parseDTO(figurinha);
		}

		throw new EntityNotFoundException();
	}

	public FigurinhaDTO criar(FigurinhaDTO figurinhaDTO) {
		Figurinha figurinha = mapper.parseEntity(figurinhaDTO);
		figurinha.setId(null);
		repository.save(figurinha);
		return mapper.parseDTO(figurinha);
	}

	public FigurinhaDTO editar(String id, FigurinhaDTO figurinhaDTO) {

		Optional<Figurinha> figurinhaOp = repository.findById(id);

		if (figurinhaOp.isPresent()) {
			Figurinha figurinha = figurinhaOp.get();
			figurinha.setImagem(figurinhaDTO.getImagem());
			figurinha.setIdColecao(figurinhaDTO.getIdColecao());
			figurinha.setDescricao(figurinhaDTO.getDescricao());
			figurinha.setRaridade(figurinhaDTO.getRaridade());
			figurinha.setPreco(figurinhaDTO.getPreco());
			figurinha.setId(id);
			figurinha = repository.save(figurinha);
			return mapper.parseDTO(figurinha);
		}

		throw new EntityNotFoundException();
	}

	public void excluir(String id) {
		if (!repository.existsById(id)) {
			throw new EntityNotFoundException();
		}

		repository.deleteById(id);
	}

}
