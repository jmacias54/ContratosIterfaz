package com.mx.contratos.domain.repository;

import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;

import java.util.List;

public interface EmployeeRepository {

	boolean nameAndLastnameIsUnique(String name, String lastName);

	boolean exists(Long userId);

	EmployeeDomain getById(Long userId);

	EmployeeDomain create(EmployeeCreateInput input);

	List<EmployeeDomain> search(Long jobId);


}
