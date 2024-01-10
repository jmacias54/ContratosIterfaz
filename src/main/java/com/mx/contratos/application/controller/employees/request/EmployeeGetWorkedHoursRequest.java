package com.mx.contratos.application.controller.employees.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.contratos.application.controller.validator.EmployeeExist;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeGetWorkedHoursRequest {

	@Schema(description = "id of Employee's", example = "1234")
	@NotNull(message = "employee.id.null")
	@EmployeeExist(message = "employee.notFound")
	@JsonProperty("employee_id")
	private final Long employeeId;

	@Schema(description = "worked date of Employee's", example = "2023-01-01")
	@NotNull(message = "employee.workedDate.null")
	@JsonProperty("start_date")
	@PastOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final Date startDate;

	@Schema(description = "worked date of Employee's", example = "2023-01-01")
	@NotNull(message = "employee.workedDate.null")
	@JsonProperty("end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final Date endDate;

	@AssertTrue(message = "End date must be after start date")
	private boolean isValidRange() {
		LocalDate localDateStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localDateEndDate = endDate != null ? endDate.toInstant()
			.atZone(ZoneId.systemDefault())
			.toLocalDate() : null;
		return endDate == null || startDate == null || !localDateEndDate.isBefore(localDateStartDate);
	}

}
