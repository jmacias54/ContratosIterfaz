package com.mx.contratos.infrastructure.persistence.jpa.mysql.employee;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.model.GenderDomain;
import com.mx.contratos.domain.model.JobDomain;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Gender;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Job;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeToEmployeeDomainMapper implements Mapper<Employee, EmployeeDomain> {

	private final Mapper<Gender, GenderDomain> genderToGenderDomainMapper;
	private final Mapper<Job, JobDomain> jobToJobDomainMapper;


	@Override
	public EmployeeDomain map(Employee entity) {

		return new EmployeeDomain(
			entity.getId(),
			this.genderToGenderDomainMapper.map(entity.getGender()),
			this.jobToJobDomainMapper.map(entity.getJob()),
			entity.getName(),
			entity.getLastName(),
			entity.getBirthdate()
		);
	}
}
