
package com.ejemplo.SpringBoot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistAuthenticationException extends RuntimeException {
  private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE = "User not found with username %s";
	
	public UserAlreadyExistAuthenticationException(String username) {
		super(String.format(MESSAGE, username));
	}  
    
}
