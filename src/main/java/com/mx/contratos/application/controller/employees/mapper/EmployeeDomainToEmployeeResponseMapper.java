package com.mx.contratos.application.controller.employees.mapper;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.response.EmployeeResponse;
import com.mx.contratos.application.controller.employees.response.GenderResponse;
import com.mx.contratos.application.controller.employees.response.JobResponse;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.model.GenderDomain;
import com.mx.contratos.domain.model.JobDomain;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class EmployeeDomainToEmployeeResponseMapper implements Mapper<EmployeeDomain, EmployeeResponse> {

	private final Mapper<JobDomain, JobResponse> jobDomainToJobResponseMapper;
	private final Mapper<GenderDomain, GenderResponse> genderDomainToGenderResponseMapper;

	@Override
	public EmployeeResponse map(EmployeeDomain domain) {
		return new EmployeeResponse(
			domain.getId(),
			this.genderDomainToGenderResponseMapper.map(domain.getGender()),
			this.jobDomainToJobResponseMapper.map(domain.getJob()),
			domain.getName(),
			domain.getLastName(),
			domain.getBirthdate()
		);
	}
}
