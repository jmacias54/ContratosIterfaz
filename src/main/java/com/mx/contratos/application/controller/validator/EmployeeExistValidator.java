package com.mx.contratos.application.controller.validator;

import com.mx.contratos.domain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class EmployeeExistValidator implements ConstraintValidator<EmployeeExist, Long> {

	private final EmployeeRepository employeeRepository;
	@Override
	public boolean isValid(Long employeeId, ConstraintValidatorContext context) {

		return nonNull(employeeId) && !this.employeeRepository.exists(employeeId);

	}
}
