package com.mx.contratos.infrastructure.persistence.jpa.mysql.employee;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.model.GenderDomain;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Gender;

public class GenderToGenderDomainMapper implements Mapper<Gender, GenderDomain> {
	@Override
	public GenderDomain map(Gender entity) {
		return new GenderDomain(
			entity.getId(),
			entity.getName()
		);
	}
}
