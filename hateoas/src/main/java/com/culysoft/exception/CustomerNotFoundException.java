package com.culysoft.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

}
