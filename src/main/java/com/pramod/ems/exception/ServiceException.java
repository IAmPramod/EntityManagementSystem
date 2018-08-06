package com.pramod.ems.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = -5939713223514246755L;

	public ServiceException(String message){
        super(message);
    }
}
