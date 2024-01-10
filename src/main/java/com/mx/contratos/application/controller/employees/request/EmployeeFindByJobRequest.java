package com.mx.contratos.application.controller.employees.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.contratos.application.controller.validator.JobExist;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeFindByJobRequest {

	@NotNull(message = "employee.jobId.null")
	@Schema(description = "The ID of the employee that owns the job.", example = "1234")
	@JobExist(message = "job.notFound")
	@JsonProperty("job_id")
	private Long jobId;
}
