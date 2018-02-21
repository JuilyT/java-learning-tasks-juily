package org.Generics;

public enum Status {
	IN_PROGRESS("in_progress"), COMPLETED("completed"), CANCELLED("cancelled");
	String code;

	Status(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	public static <T> Status getType(T s) {
	    for (Status category : values()) {
	        if (category.getCode().equals(s)) {
	            return category;
	        }
	    }    
	    return null;
	}
}
