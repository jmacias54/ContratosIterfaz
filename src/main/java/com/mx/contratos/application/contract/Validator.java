package com.mx.contratos.application.contract;

public interface Validator<T> {

	boolean isValid(T value);

}
