package com.mx.contratos.domain.use_case.employee.create;


import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeCreateUseCase {

	private final EmployeeRepository employeeRepository;
	private final EmployeeCreateInputValidator employeeCreateInputValidator;

	public EmployeeDomain execute(EmployeeCreateInput input) {
		this.employeeCreateInputValidator.validate(input);

		return this.employeeRepository.create(input);
	}
}
