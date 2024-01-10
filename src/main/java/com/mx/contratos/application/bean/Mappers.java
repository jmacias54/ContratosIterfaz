package com.mx.contratos.application.bean;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.mapper.*;
import com.mx.contratos.application.controller.employees.request.EmployeeAddHoursRequest;
import com.mx.contratos.application.controller.employees.request.EmployeeCreateRequest;
import com.mx.contratos.application.controller.employees.response.EmployeeResponse;
import com.mx.contratos.application.controller.employees.response.GenderResponse;
import com.mx.contratos.application.controller.employees.response.JobResponse;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.domain.model.GenderDomain;
import com.mx.contratos.domain.model.JobDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Gender;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Job;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.EmployeeCreateInputToEmployeeMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.EmployeeToEmployeeDomainMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.GenderToGenderDomainMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.employee.JobToJobDomainMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.worked_hours.EmployeeAddHoursInputToEmployeeWorkedHoursMapper;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.worked_hours.EmployeeWorkedHoursToEmployeeWorkedHoursDomainMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mappers {

	@Bean
	public Mapper<EmployeeDomain, EmployeeResponse> employeeDomainToEmployeeResponseMapper(
		Mapper<JobDomain, JobResponse> jobDomainToJobResponseMapper,
		Mapper<GenderDomain, GenderResponse> genderDomainToGenderResponseMapper
	) {
		return new EmployeeDomainToEmployeeResponseMapper(
			jobDomainToJobResponseMapper,
			genderDomainToGenderResponseMapper
		);
	}


	@Bean
	public Mapper<JobDomain, JobResponse> jobDomainToJobResponseMapper() {
		return new JobDomainToJobResponseMapper();
	}

	@Bean
	public Mapper<GenderDomain, GenderResponse> genderDomainToGenderResponseMapper() {
		return new GenderDomainToGenderResponseMapper();
	}

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
	public Mapper<Employee, EmployeeDomain> employeeToEmployeeDomainMapper(
		Mapper<Gender, GenderDomain> genderToGenderDomainMapper,
		Mapper<Job, JobDomain> jobToJobDomainMapper
	) {
		return new EmployeeToEmployeeDomainMapper(
			genderToGenderDomainMapper,
			jobToJobDomainMapper
		);
	}

	@Bean
	public Mapper<Gender, GenderDomain> genderToGenderDomainMapper() {
		return new GenderToGenderDomainMapper();
	}

	@Bean
	public Mapper<Job, JobDomain> jobToJobDomainMapper() {
		return new JobToJobDomainMapper();
	}

	@Bean
	public Mapper<EmployeeCreateInput, Employee> employeeCreateInputToEmployeeMapper() {
		return new EmployeeCreateInputToEmployeeMapper();
	}

}
