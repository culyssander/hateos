package com.culysoft.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.culysoft.exception.SoldadoNotFoundException;

@ControllerAdvice
public class SoldadoControllerAdvance {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(SoldadoNotFoundException.class)
	public String soldadoNotFound(SoldadoNotFoundException soldadoNotFoundException) {
		return "Soldado não encontrado.";
	}
}
