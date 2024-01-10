package com.mx.contratos.application.bean;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.domain.repository.EmployeeRepository;
import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import com.mx.contratos.domain.repository.GenderRepository;
import com.mx.contratos.domain.repository.JobRepository;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.JpaEmployeeRepository;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.JpaEmployeeWorkedHoursRepository;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.JpaGenderRepository;
import com.mx.contratos.infrastructure.persistence.jpa.mysql.JpaJobRepository;
import com.mx.contratos.infrastructure.persistence.jpa.repository.EmployeeRepositoryJpa;
import com.mx.contratos.infrastructure.persistence.jpa.repository.EmployeeWorkedHoursRepositoryJpa;
import com.mx.contratos.infrastructure.persistence.jpa.repository.GenderRepositoryJpa;
import com.mx.contratos.infrastructure.persistence.jpa.repository.JobRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Repositories {


	@Bean
	public JobRepository jobRepository(JobRepositoryJpa jobRepositoryJpa) {
		return new JpaJobRepository(jobRepositoryJpa);
	}

	@Bean
	public GenderRepository genderRepository(GenderRepositoryJpa genderRepositoryJpa) {
		return new JpaGenderRepository(genderRepositoryJpa);
	}

	@Bean
	public EmployeeRepository employeeRepository(
		EmployeeRepositoryJpa employeeRepositoryJpa,
		GenderRepositoryJpa genderRepositoryJpa,
		JobRepositoryJpa jobRepositoryJpa,
		Mapper<EmployeeCreateInput, Employee> employeeCreateInputToEmployeeMapper,
		Mapper<Employee, EmployeeDomain> employeeToEmployeeDomainMapper
	) {
		return new JpaEmployeeRepository(
			employeeRepositoryJpa,
			genderRepositoryJpa,
			jobRepositoryJpa,
			employeeCreateInputToEmployeeMapper,
			employeeToEmployeeDomainMapper
		);
	}

	@Bean
	public EmployeeWorkedHoursRepository employeeWorkedHoursRepository(
		EmployeeWorkedHoursRepositoryJpa employeeWorkedHoursRepositoryJpa,
		EmployeeRepositoryJpa employeeRepositoryJpa,
		Mapper<EmployeeAddHoursInput, EmployeeWorkedHours> employeeAddHoursInputToEmployeeWorkedHoursMapper,
		Mapper<EmployeeWorkedHours, EmployeeWorkedHoursDomain> employeeWorkedHoursToEmployeeWorkedHoursDomainMapper
	) {
		return new JpaEmployeeWorkedHoursRepository(employeeWorkedHoursRepositoryJpa,
			employeeRepositoryJpa,
			employeeAddHoursInputToEmployeeWorkedHoursMapper,
			employeeWorkedHoursToEmployeeWorkedHoursDomainMapper);
	}


}