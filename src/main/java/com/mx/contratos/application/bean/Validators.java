package com.mx.contratos.application.bean;

import com.mx.contratos.domain.repository.EmployeeRepository;
import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInputValidator;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInputValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Validators {

	@Bean
	public EmployeeCreateInputValidator employeeCreateInputValidator(EmployeeRepository employeeRepository) {
		return new EmployeeCreateInputValidator(employeeRepository);
	}

	@Bean
	public EmployeeAddHoursInputValidator employeeAddHoursInputValidator(EmployeeWorkedHoursRepository employeeWorkedHoursRepository) {
		return new EmployeeAddHoursInputValidator(employeeWorkedHoursRepository);
	}


}

