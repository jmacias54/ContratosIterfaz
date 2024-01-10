package com.mx.contratos.application.controller.employees.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Gender;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Job;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Accessors(chain = true)
public class EmployeeResponse {

	@JsonProperty("id")
	private final Long id;

	private final GenderResponse gender;

	private final JobResponse job;

	@JsonProperty("name")
	private final String name;

	@JsonProperty("last_name")
	private final String lastName;

	@JsonProperty("birthdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private final Date birthdate;
}
