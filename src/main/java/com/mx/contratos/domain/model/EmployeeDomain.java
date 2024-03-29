package com.mx.contratos.domain.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class EmployeeDomain {

	private final Long id;
	private final GenderDomain gender;
	private final JobDomain job;
	private final String name;
	private final String lastName;
	private final Date birthdate;
}
