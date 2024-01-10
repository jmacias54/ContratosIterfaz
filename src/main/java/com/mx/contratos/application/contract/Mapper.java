package com.mx.contratos.application.contract;

public interface Mapper<From, To> {

	To map(From input);

}


