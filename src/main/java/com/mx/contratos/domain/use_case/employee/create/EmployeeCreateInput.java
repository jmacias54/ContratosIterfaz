package com.mx.contratos.domain.use_case.employee.create;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class EmployeeCreateInput {

	private final Long genderId;
	private final Long jobId;
	private final String name;
	private String lastName;
	private final Date birthdate;

	public Optional<String> getLastName() {
		return Optional.ofNullable(lastName);
	}

}
