package it.alarit.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.alarit.api.exception.NoElementsException;

public abstract class AbstractApiController{
	
	@ExceptionHandler({NullPointerException.class, NoElementsException.class})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody String handleNullPointerException(Exception e) {
		return getErrMsg(HttpStatus.NO_CONTENT, e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody String handleException(Exception e) {
	    return getErrMsg(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
	}
	
	private String getErrMsg(HttpStatus status, String msg){
		return status + " " + msg;
	}
}
