package org.Generics;

public enum Week {
	MON(1),TUE(2),WED(3),THURS(4),FRI(5),SAT(6),SUN(7);
	private Integer code;
	Week(int code) {
		this.code=code;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public static <T> Week getType(T name) {
	    for (Week category : values()) {
	        if (category.getCode().equals(name)) {
	            return category;
	        }
	    }    
	    return null;
	}
}
