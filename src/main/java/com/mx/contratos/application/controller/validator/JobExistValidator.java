package com.mx.contratos.application.controller.validator;

import com.mx.contratos.domain.repository.JobRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class JobExistValidator implements ConstraintValidator<JobExist, Long> {

	private final JobRepository jobRepository;

	@Override
	public boolean isValid(Long jobId, ConstraintValidatorContext context) {
		return nonNull(jobId) && this.jobRepository.exists(jobId);
	}
}
