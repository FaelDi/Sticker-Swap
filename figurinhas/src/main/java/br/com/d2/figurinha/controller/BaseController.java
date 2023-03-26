package br.com.d2.figurinha.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.d2.figurinha.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseController<T,S extends BaseService<T>> {
	
	protected S service;
	
	protected BaseController(S service) {
		this.service = service;
	}

    @GetMapping
    public ResponseEntity<List<T>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> buscarUm(@PathVariable("id") String id) {
        try {
        	
        	return ResponseEntity.ok(service.buscarUm(id));
        	
        }catch(EntityNotFoundException ex) {
        	
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception ex) {
        	
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public ResponseEntity<T> criar(@RequestBody @Valid T entidade) {
        try {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(service.criar(entidade));

        }catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> editar(@PathVariable("id") String id,
                                    @RequestBody @Valid T entidade) {
        try {

        	return ResponseEntity.ok(service.editar(id, entidade));

        }catch(EntityNotFoundException ex) {
        	
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception ex) {
        	
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable("id") String id) {
        try {
        	
        	service.excluir(id);
        	return ResponseEntity.status(HttpStatus.OK).build();
        	
        }catch(EntityNotFoundException ex) {
        	
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch(Exception ex) {
        	
            log.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
