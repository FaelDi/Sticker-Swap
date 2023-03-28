package com.ada.album.transacao.domain.model;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "albumId", "figurinhaId" }) })
public class Figurinha {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long tipoAlbumId;
	
	@Column(nullable = false)
	private Long tipoFigurinhaId;
	
	private Integer quantidade;
	
	@ManyToAny
	@JoinColumn(nullable = false)
	private Album album;
	

}
