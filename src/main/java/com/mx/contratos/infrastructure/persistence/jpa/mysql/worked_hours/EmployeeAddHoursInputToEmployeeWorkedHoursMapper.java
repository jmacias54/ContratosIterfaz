package com.mx.contratos.infrastructure.persistence.jpa.mysql.worked_hours;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;

public class EmployeeAddHoursInputToEmployeeWorkedHoursMapper implements Mapper<EmployeeAddHoursInput, EmployeeWorkedHours> {
	@Override
	public EmployeeWorkedHours map(EmployeeAddHoursInput input) {
		EmployeeWorkedHours entity = new EmployeeWorkedHours();
		entity.setWorkedHours(input.getWorkedHours());
		entity.setWorkedDate(input.getWorkedDate());
		return entity;
	}
}
