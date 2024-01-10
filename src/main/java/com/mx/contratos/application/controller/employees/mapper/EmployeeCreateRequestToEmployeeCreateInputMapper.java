package com.mx.contratos.application.controller.employees.mapper;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.request.EmployeeCreateRequest;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;

public class EmployeeCreateRequestToEmployeeCreateInputMapper implements Mapper<EmployeeCreateRequest, EmployeeCreateInput> {
	@Override
	public EmployeeCreateInput map(EmployeeCreateRequest request) {
		EmployeeCreateInput input = new EmployeeCreateInput(
			request.getGenderId(),
			request.getJobId(),
			request.getName(),
			request.getBirthdate()
		);

		request.getLastName().ifPresent(input::setLastName);

		return input;
	}
}
