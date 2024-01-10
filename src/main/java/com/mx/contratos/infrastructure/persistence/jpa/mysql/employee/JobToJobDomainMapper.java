package com.mx.contratos.infrastructure.persistence.jpa.mysql.employee;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.JobDomain;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Job;

public class JobToJobDomainMapper implements Mapper<Job, JobDomain> {
	@Override
	public JobDomain map(Job entity) {
		return new JobDomain(
			entity.getId(),
			entity.getName(),
			entity.getSalary()
		);
	}
}
