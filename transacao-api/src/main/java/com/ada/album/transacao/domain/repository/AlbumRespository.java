package com.ada.album.transacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ada.album.transacao.domain.model.Album;

@Repository
public interface AlbumRespository extends JpaRepository<Album, Long>{

}
