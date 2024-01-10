package com.mx.contratos.application.controller.employees.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeGetWorkedHoursResponse {

	@JsonProperty("total_worked_hours")
	private final Long totalHours;
	private final Boolean success;
}
