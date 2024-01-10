package com.mx.contratos.infrastructure.persistence.jpa.mysql;

import com.mx.contratos.domain.repository.JobRepository;
import com.mx.contratos.infrastructure.persistence.jpa.repository.JobRepositoryJpa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaJobRepository implements JobRepository {

	private final JobRepositoryJpa jobRepositoryJpa;

	@Override
	public boolean exists(Long jobId) {
		return this.jobRepositoryJpa.existsById(jobId);
	}
}
