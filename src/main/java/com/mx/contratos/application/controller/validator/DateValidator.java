package com.mx.contratos.application.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateValidator implements ConstraintValidator<DateNotFuture, Date> {

	@Override
	public void initialize(DateNotFuture constraintAnnotation) {
	}

	@Override
	public boolean isValid(Date date, ConstraintValidatorContext context) {
		if (date == null) {
			return true; // Puede que desees manejar nulos de otra manera
		}

		Date currentDate = new Date();
		return !date.after(currentDate);
	}
}
