package org.Generics;

public enum Currency {
	RUPEE("rupee"), DOLLAR("dollar"), POUND("pound");
	String val;
	Currency(String val){
		this.val = val;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public static <T> Currency getType(T s) {
	    for (Currency category : values()) {
	        if (category.getVal().equals(s)) {
	            return category;
	        }
	    }    
	    return null;
	}

}
