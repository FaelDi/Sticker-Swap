package com.ada.album.transacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ada.album.transacao.domain.model.Figurinha;

@Repository
public interface FigurinhaRespository extends JpaRepository<Figurinha, Long>{

}
