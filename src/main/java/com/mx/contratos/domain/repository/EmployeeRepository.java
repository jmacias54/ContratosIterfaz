package com.mx.contratos.domain.repository;

import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;

public interface EmployeeRepository {

	boolean nameAndLastnameIsUnique(String name, String lastName);

	EmployeeDomain create(EmployeeCreateInput input);
}
