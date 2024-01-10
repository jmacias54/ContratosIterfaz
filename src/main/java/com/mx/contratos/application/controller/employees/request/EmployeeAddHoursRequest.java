package com.mx.contratos.application.controller.employees.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.contratos.application.controller.validator.DateNotFuture;
import com.mx.contratos.application.controller.validator.EmployeeExist;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeAddHoursRequest {

	@Schema(description = "id of Employee's", example = "1234")
	@NotNull(message = "employee.id.null")
	@EmployeeExist(message = "employee.notFound")
	@JsonProperty("employee_id")
	private final Long employeeId;

	@Schema(description = "worked hours of Employee's", example = "1234")
	@NotNull(message = "employee.workedHours.null")
	@JsonProperty("worked_hours")
	@Max(value = 20, message = "employee.workedHours.invalid")
	private final Long workedHours;

	@Schema(description = "worked date of Employee's", example = "2023-01-01")
	@NotNull(message = "employee.workedDate.null")
	@JsonProperty("worked_date")
	@DateNotFuture(message = "employee.workedDate.invalid")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final Date workedDate;

}
