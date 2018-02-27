package org.customannotations.fieldvalidators;

public interface Validator<T> {
	public boolean isValid(T value);
}
