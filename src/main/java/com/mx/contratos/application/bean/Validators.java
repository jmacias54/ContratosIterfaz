package com.mx.contratos.application.bean;

import com.mx.contratos.domain.repository.EmployeeRepository;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInputValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Validators {


	@Bean
	public EmployeeCreateInputValidator employeeCreateInputValidator(EmployeeRepository employeeRepository) {
		return new EmployeeCreateInputValidator(employeeRepository);
	}

}

