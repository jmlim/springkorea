package org.springkorea.exception;

public class UserNotAuthorityException extends Exception {

	private static final long serialVersionUID = 4882617035818401856L;

	public UserNotAuthorityException(String message) {
		super(message);
	}
}
