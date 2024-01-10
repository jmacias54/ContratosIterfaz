package com.mx.contratos.infrastructure.persistence.jpa.mysql.employee;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;

public class EmployeeCreateInputToEmployeeMapper implements Mapper<EmployeeCreateInput, Employee> {
	@Override
	public Employee map(EmployeeCreateInput input) {
		Employee employee = new Employee();
		employee.setName(input.getName());
		employee.setBirthdate(input.getBirthdate());
		input.getLastName().ifPresent(employee::setLastName);

		return employee;
	}
}
