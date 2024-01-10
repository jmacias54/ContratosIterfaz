package com.mx.contratos.domain.repository;

import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;

import java.util.Date;

public interface EmployeeWorkedHoursRepository {

	boolean WorkedDateAndEmployeeNonUnique(Date workedDate, long employeeId);

	EmployeeWorkedHoursDomain create(EmployeeAddHoursInput input);

}
