package com.mx.contratos.domain.use_case.employee.list;

import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeSearchUseCase {

	private final EmployeeRepository employeeRepository;

	public List<EmployeeDomain> execute(Long jobId) {

		return this.employeeRepository.search(jobId);
	}
}
