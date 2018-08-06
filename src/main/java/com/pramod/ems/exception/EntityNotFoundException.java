package com.pramod.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = -3950534567259319598L;

	public EntityNotFoundException(String message){
        super(message);
    }
}
