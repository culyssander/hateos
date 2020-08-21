package com.culysoft.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SoldadoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

}
