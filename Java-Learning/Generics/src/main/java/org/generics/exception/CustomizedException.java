package org.generics.exception;

public class CustomizedException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public CustomizedException(String msg) {
		this.message = msg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
