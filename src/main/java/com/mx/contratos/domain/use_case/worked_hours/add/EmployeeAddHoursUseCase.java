package com.mx.contratos.domain.use_case.worked_hours.add;

import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeAddHoursUseCase {

	private final EmployeeWorkedHoursRepository employeeWorkedHoursRepository;
	private final EmployeeAddHoursInputValidator employeeAddHoursInputValidator;

	public EmployeeWorkedHoursDomain execute(EmployeeAddHoursInput input) {
		this.employeeAddHoursInputValidator.validate(input);
		return this.employeeWorkedHoursRepository.create(input);
	}
}
