package com.mx.contratos.application.controller.employees.mapper;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.response.JobResponse;
import com.mx.contratos.domain.model.JobDomain;

public class JobDomainToJobResponseMapper implements Mapper<JobDomain, JobResponse> {
	@Override
	public JobResponse map(JobDomain domain) {
		return new JobResponse(
			domain.getId(),
			domain.getName(),
			domain.getSalary()
		);
	}
}
