package com.mx.contratos.infrastructure.persistence.jpa.mysql.worked_hours;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;

public class EmployeeWorkedHoursToEmployeeWorkedHoursDomainMapper implements Mapper<EmployeeWorkedHours, EmployeeWorkedHoursDomain> {
	@Override
	public EmployeeWorkedHoursDomain map(EmployeeWorkedHours input) {
		return new EmployeeWorkedHoursDomain(input.getId());
	}
}
