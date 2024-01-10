package com.mx.contratos.application.bean;

import com.mx.contratos.domain.repository.EmployeeRepository;
import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInputValidator;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateUseCase;
import com.mx.contratos.domain.use_case.employee.list.EmployeeSearchUseCase;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInputValidator;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursUseCase;
import com.mx.contratos.domain.use_case.worked_hours.search.PaymentSearchUseCase;
import com.mx.contratos.domain.use_case.worked_hours.search.WorkedHoursSearchUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCases {


	@Bean
	public PaymentSearchUseCase paymentSearchUseCase(
		EmployeeWorkedHoursRepository employeeWorkedHoursRepository,
		EmployeeRepository employeeRepository
	) {
		return new PaymentSearchUseCase(employeeWorkedHoursRepository, employeeRepository);
	}

	@Bean
	public WorkedHoursSearchUseCase workedHoursSearchUseCase(
		EmployeeWorkedHoursRepository employeeWorkedHoursRepository
	) {
		return new WorkedHoursSearchUseCase(employeeWorkedHoursRepository);
	}

	@Bean
	public EmployeeSearchUseCase employeeSearchUseCase(
		EmployeeRepository employeeRepository
	) {
		return new EmployeeSearchUseCase(employeeRepository);
	}

	@Bean
	public EmployeeCreateUseCase employeeCreateUseCase(
		EmployeeRepository employeeRepository,
		EmployeeCreateInputValidator employeeCreateInputValidator
	) {
		return new EmployeeCreateUseCase(employeeRepository, employeeCreateInputValidator);
	}

	@Bean
	public EmployeeAddHoursUseCase employeeAddHoursUseCase(
		EmployeeWorkedHoursRepository employeeWorkedHoursRepository,
		EmployeeAddHoursInputValidator employeeAddHoursInputValidator
	) {
		return new EmployeeAddHoursUseCase(employeeWorkedHoursRepository, employeeAddHoursInputValidator);
	}

}
