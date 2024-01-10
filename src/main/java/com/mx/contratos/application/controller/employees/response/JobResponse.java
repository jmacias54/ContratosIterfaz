package com.mx.contratos.application.controller.employees.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class JobResponse {

	private final Long id;

	private final String name;

	private final Double salary;

}
