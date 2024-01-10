package com.mx.contratos.application.bean;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.mapper.EmployeeAddHoursRequestToEmployeeAddHoursInputMapper;
import com.mx.contratos.application.controller.employees.mapper.EmployeeCreateRequestToEmployeeCreateInputMapper;
import com.mx.contratos.application.controller.employees.request.EmployeeAddHoursRequest;
import com.mx.contratos.application.controller.employees.request.EmployeeCreateRequest;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.EmployeeCreateInputToEmployeeMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.EmployeeToEmployeeDomainMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.worked_hours.EmployeeAddHoursInputToEmployeeWorkedHoursMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.worked_hours.EmployeeWorkedHoursToEmployeeWorkedHoursDomainMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {


	@Bean
	public Mapper<EmployeeWorkedHours, EmployeeWorkedHoursDomain> employeeWorkedHoursToEmployeeWorkedHoursDomainMapper() {
		return new EmployeeWorkedHoursToEmployeeWorkedHoursDomainMapper();
	}
	@Bean
	public Mapper<EmployeeAddHoursInput, EmployeeWorkedHours> employeeAddHoursInputToEmployeeWorkedHoursMapper() {
		return new EmployeeAddHoursInputToEmployeeWorkedHoursMapper();
	}

	@Bean
	public Mapper<EmployeeAddHoursRequest, EmployeeAddHoursInput> employeeAddHoursRequestToEmployeeAddHoursInputMapper() {
		return new EmployeeAddHoursRequestToEmployeeAddHoursInputMapper();
	}

	@Bean
	public Mapper<EmployeeCreateRequest, EmployeeCreateInput> employeeCreateRequestToEmployeeCreateInputMapper() {
		return new EmployeeCreateRequestToEmployeeCreateInputMapper();
	}

	@Bean
	public Mapper<Employee, EmployeeDomain> employeeToEmployeeDomainMapper() {
		return new EmployeeToEmployeeDomainMapper();
	}

	@Bean
	public Mapper<EmployeeCreateInput, Employee> employeeCreateInputToEmployeeMapper() {
		return new EmployeeCreateInputToEmployeeMapper();
	}

}
