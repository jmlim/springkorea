package org.springkorea.exception;

import java.util.List;

import org.springframework.validation.FieldError;

public class UserValidationException extends Exception {

	private static final long serialVersionUID = 5931603639055198475L;

	private List<FieldError> errors;

	public UserValidationException(List<FieldError> errors) {
		this.errors = errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}
}
