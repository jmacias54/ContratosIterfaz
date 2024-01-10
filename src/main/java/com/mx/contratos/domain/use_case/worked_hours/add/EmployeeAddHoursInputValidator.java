package com.mx.contratos.domain.use_case.worked_hours.add;

import com.mx.contratos.domain.exception.BadRequestException;
import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeAddHoursInputValidator {

	private final EmployeeWorkedHoursRepository employeeWorkedHoursRepository;

	public void validate(EmployeeAddHoursInput input) {

		if(!this.employeeWorkedHoursRepository.WorkedDateAndEmployeeNonUnique(
			input.getWorkedDate(),
			input.getEmployeeId()
		)) {
			throw new BadRequestException("employee.workedDate.nonUnique");
		}
	}
}
