package com.mx.contratos.application.controller.employees.mapper;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.request.EmployeeAddHoursRequest;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;

public class EmployeeAddHoursRequestToEmployeeAddHoursInputMapper implements Mapper<EmployeeAddHoursRequest, EmployeeAddHoursInput> {
	@Override
	public EmployeeAddHoursInput map(EmployeeAddHoursRequest request) {
		return new EmployeeAddHoursInput(
			request.getEmployeeId(),
			request.getWorkedHours(),
			request.getWorkedDate()
		);
	}
}
