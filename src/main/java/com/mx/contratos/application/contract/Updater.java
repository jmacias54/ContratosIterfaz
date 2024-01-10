package com.mx.contratos.application.contract;

public interface Updater<ToUpdate, Input> {

	ToUpdate update(ToUpdate entity, Input data);

}

