package org.springkorea.exception.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springkorea.exception.UserValidationException;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		return "error";
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserValidationException.class)
	public @ResponseBody List<String> userValidationException(
			UserValidationException e) {
		List<String> validationMessages = new ArrayList<String>();
		for (FieldError error : e.getErrors()) {
			validationMessages.add(error.getDefaultMessage());
		}
		return validationMessages;
	}
}
