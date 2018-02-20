package org.customannotations;

public interface Validator<T> {
	public boolean isValid(T value);
}
