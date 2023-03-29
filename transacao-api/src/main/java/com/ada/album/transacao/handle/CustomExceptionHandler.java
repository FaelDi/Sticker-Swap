package com.ada.album.transacao.handle;

import com.ada.album.transacao.api.model.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(ErrorException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<MessageDTO> handleErrorException(ErrorException ex) {
		MessageDTO errorTemplate = new MessageDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
		return new ResponseEntity<>(errorTemplate, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}