package com.ada.album.transacao.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ada.album.transacao.api.model.AlbumDTO;
import com.ada.album.transacao.api.model.input.AlbumInput;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/albuns")
public class AlbumController {
	
	@GetMapping("/{id}")
    public AlbumDTO buscar(@PathVariable Long id) {
		return null;
	}
	
	@GetMapping
	public List<AlbumDTO> listar() {
		return null;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public AlbumDTO emitir(@RequestBody @Valid AlbumInput albumInput) {
		return null;
	}

}
