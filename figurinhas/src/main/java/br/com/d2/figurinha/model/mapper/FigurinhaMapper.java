package br.com.d2.figurinha.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.d2.figurinha.model.dto.FigurinhaDTO;
import br.com.d2.figurinha.model.entity.Figurinha;

@Mapper(componentModel = "spring")
public interface FigurinhaMapper {
	List<FigurinhaDTO> parseListDTO(List<Figurinha> figurinhas);
	List<Figurinha> parseListEntity(List<FigurinhaDTO> figurinhas);

	FigurinhaDTO parseDTO(Figurinha figurinha);

	Figurinha parseEntity(FigurinhaDTO figurinha);
}
