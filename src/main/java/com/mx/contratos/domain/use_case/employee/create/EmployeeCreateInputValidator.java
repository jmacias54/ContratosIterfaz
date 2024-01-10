package com.mx.contratos.domain.use_case.employee.create;

import com.mx.contratos.domain.exception.BadRequestException;
import com.mx.contratos.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeCreateInputValidator {

	private final EmployeeRepository employeeRepository;

	public void validate(EmployeeCreateInput input) {
		String lastname = input.getLastName().isEmpty() ? null : input.getLastName().get();
		if(!this.employeeRepository.nameAndLastnameIsUnique(input.getName(), lastname)) {
			throw new BadRequestException("employee.nonUnique");
		}
	}
}
