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

import com.ada.album.transacao.api.model.FigurinhaDTO;
import com.ada.album.transacao.api.model.input.FigurinhaInput;
import com.ada.album.transacao.api.model.input.TransferenciaFigurinhaInput;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/figurinhas")
public class FigurinhaController {
	
	@GetMapping("/{id}")
    public FigurinhaDTO buscar(@PathVariable("id") String id) {
		return null;
	}
	
	@GetMapping
	public List<FigurinhaDTO> listar() {
		return null;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public FigurinhaDTO emitir(@RequestBody @Valid FigurinhaInput figurinhaInput) {
		return null;
	}
	
	@PostMapping
	public FigurinhaDTO transferir(@RequestBody @Valid TransferenciaFigurinhaInput transferenciaFigurinhaInput) {
		return null;
	}

}
