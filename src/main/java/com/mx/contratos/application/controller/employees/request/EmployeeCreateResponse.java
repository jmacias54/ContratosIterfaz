package com.mx.contratos.application.controller.employees.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeCreateResponse {

	private final Long id;
	private final Boolean success;

}
