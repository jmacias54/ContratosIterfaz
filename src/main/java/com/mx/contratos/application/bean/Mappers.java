package com.mx.contratos.application.bean;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.mapper.EmployeeCreateRequestToEmployeeCreateInputMapper;
import com.mx.contratos.application.controller.employees.request.EmployeeCreateRequest;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.EmployeeCreateInputToEmployeeMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.EmployeeToEmployeeDomainMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {

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
