package com.ada.album.transacao.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "tipoAlbumId", "tipoFigurinhaId" }) })
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
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Album album;
	

}
