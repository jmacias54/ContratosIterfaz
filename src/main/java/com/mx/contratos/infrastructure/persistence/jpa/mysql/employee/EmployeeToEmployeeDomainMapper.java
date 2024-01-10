package com.mx.contratos.infrastructure.persistence.jpa.mysql.employee;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;

public class EmployeeToEmployeeDomainMapper implements Mapper<Employee, EmployeeDomain> {
	@Override
	public EmployeeDomain map(Employee entity) {
		return new EmployeeDomain(entity.getId());
	}
}
