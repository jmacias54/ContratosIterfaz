package com.mx.contratos.domain.repository;

import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;

import java.util.Date;

public interface EmployeeRepository {

	boolean nameAndLastnameIsUnique(String name, String lastName);

	boolean exists(Long userId);

	EmployeeDomain create(EmployeeCreateInput input);


}
