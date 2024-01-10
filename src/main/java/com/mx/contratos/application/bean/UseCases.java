package com.mx.contratos.application.bean;

import com.mx.contratos.domain.repository.EmployeeRepository;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInputValidator;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCases {

	@Bean
	public EmployeeCreateUseCase employeeCreateUseCase(
		EmployeeRepository employeeRepository,
		EmployeeCreateInputValidator employeeCreateInputValidator
	) {
		return new EmployeeCreateUseCase(employeeRepository, employeeCreateInputValidator);
	}

}
