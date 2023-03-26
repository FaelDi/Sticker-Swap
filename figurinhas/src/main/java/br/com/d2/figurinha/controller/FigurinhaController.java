package br.com.d2.figurinha.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.d2.figurinha.model.dto.ColecaoDTO;
import br.com.d2.figurinha.model.dto.FigurinhaDTO;
import br.com.d2.figurinha.service.ColecaoService;
import br.com.d2.figurinha.service.FigurinhaService;
import jakarta.annotation.Nonnull;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/figurinhas")
@Slf4j
public class FigurinhaController extends BaseController<FigurinhaDTO, FigurinhaService> {

	
	private ColecaoService colecaoService;
	
	public FigurinhaController(FigurinhaService service, ColecaoService colecaoService) {
		super(service);
		this.colecaoService = colecaoService;
	}

	@PostMapping("/colecao")
	public ResponseEntity<List<FigurinhaDTO>> criarColecao(@RequestBody @Valid @Nonnull ColecaoDTO colecao) {
		try {

			return ResponseEntity
					.status(HttpStatus.CREATED)
					.contentType(MediaType.APPLICATION_JSON)
					.body(colecaoService.criarColecao(colecao));

		} catch (Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/colecao")
	public ResponseEntity<List<FigurinhaDTO>> getColecao(@RequestParam @Valid @Nonnull String idColecao, @RequestParam @Valid @Nonnull String qtd) {
		try {

			return ResponseEntity
					.status(HttpStatus.OK)
					.contentType(MediaType.APPLICATION_JSON)
					.body(colecaoService.getColecao(idColecao, qtd));

		} catch (Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
