package com.mx.contratos.application.controller.employees.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeFindByJobResponse {

	private List<EmployeeResponse> employees;
}
