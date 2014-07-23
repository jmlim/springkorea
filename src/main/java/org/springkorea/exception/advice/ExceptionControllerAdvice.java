package org.springkorea.exception.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springkorea.exception.UserNotAuthorityException;
import org.springkorea.exception.UserValidationException;

/**
 * @author jmlim
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserNotAuthorityException.class)
	public @ResponseBody String userNotAuthorityException(
			UserNotAuthorityException e) {
		return e.getMessage();
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UserValidationException.class)
	public @ResponseBody List<String> userValidationException(
			UserValidationException e) {
		List<String> validationMessages = new ArrayList<>();
		for (FieldError error : e.getErrors()) {
			validationMessages.add(error.getDefaultMessage());
		}
		return validationMessages;
	}
}
