package com.mx.contratos.application.controller.employees.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.contratos.application.controller.validator.BirthdateIsValid;
import com.mx.contratos.application.controller.validator.GenderExist;
import com.mx.contratos.application.controller.validator.JobExist;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Data
@Accessors(chain = true)
@Schema(description = "Employee Create Request")
public class EmployeeCreateRequest {


	@NotNull(message = "employee.genderId.null")
	@Schema(description = "The ID of the employee that owns the gender.", example = "1234")
	@GenderExist(message = "gender.notFound")
	@JsonProperty("gender_id")
	private final Long genderId;

	@NotNull(message = "employee.jobId.null")
	@Schema(description = "The ID of the employee that owns the job.", example = "1234")
	@JobExist(message = "job.notFound")
	@JsonProperty("job_id")
	private final Long jobId;

	@Schema(description = "name of employee", example = "Luis")
	@NotNull(message = "employee.name.null")
	@NotBlank(message = "employee.name.blank")
	@Size(min = 1, max = 100, message = "employee.name.size")
	@JsonProperty("name")
	private final String name;// validar que nombre y apellido no existan juntos

	@Schema(description = "last name of employee", example = "Lopez")
	@NotNull(message = "employee.lastName.null")
	@NotBlank(message = "employee.lastName.blank")
	@Size(max = 100, message = "employee.lastName.size")
	@JsonProperty("last_name")
	private String lastName;

	@NotNull(message = "employee.birthdate.null")
	@Schema(description = "id of financial entity", example = "1234")
	@BirthdateIsValid(message = "employee.birthdate.invalid")// validar que sea mayor a 18 años
	@JsonProperty("birthdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private final Date birthdate;

	public Optional<String> getLastName() {
		return Optional.ofNullable(lastName);
	}

}
