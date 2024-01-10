package com.mx.contratos.application.controller.validator;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@RequiredArgsConstructor
public class BirthdateIsValidValidator implements ConstraintValidator<BirthdateIsValid, Date> {
	@Override
	public boolean isValid(Date birthdate, ConstraintValidatorContext context) {

		if(birthdate != null) {
			LocalDate currentDate = LocalDate.now();
			LocalDate localDateBirthDate = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period period = Period.between(localDateBirthDate, currentDate);
			return (period.getYears() >= 18) ? true : false;
		}

		return false;
	}
}
