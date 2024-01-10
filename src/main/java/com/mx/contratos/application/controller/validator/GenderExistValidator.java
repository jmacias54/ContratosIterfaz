package com.mx.contratos.application.controller.validator;


import com.mx.contratos.domain.repository.GenderRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class GenderExistValidator implements ConstraintValidator<GenderExist, Long> {

	private final GenderRepository genderRepository;

	@Override
	public boolean isValid(Long genderId, ConstraintValidatorContext context) {
		return nonNull(genderId) && this.genderRepository.exists(genderId);
	}
}
