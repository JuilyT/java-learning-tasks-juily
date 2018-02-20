package org.customannotations;

public class ErrorMessage {
	String message;
	Object errorObj;
	
	public ErrorMessage(String msg, Object obj) {
		this.message = msg;
		this.errorObj = obj;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getErrorObj() {
		return errorObj;
	}
	public void setErrorObj(Object errorObj) {
		this.errorObj = errorObj;
	}
}
