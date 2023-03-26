package br.com.d2.figurinha.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.d2.figurinha.model.entity.Figurinha;

@Repository
public interface FigurinhaRepository extends JpaRepository<Figurinha, String>{

	@Query(value="SELECT * FROM figurinha where ID_COLECAO = :idColecao ORDER BY RAND() LIMIT :qtd", nativeQuery = true)
	List<Figurinha> getPacoteFigurinha(String idColecao, String qtd);
	
	@Query(value="SELECT COUNT(1) FROM figurinha where ID_COLECAO = :idColecao", nativeQuery = true)
	int getVerificaExistenciaColecao(String idColecao);
	
	List<Figurinha> findAllByIdColecao(String idColecao);
	
}
