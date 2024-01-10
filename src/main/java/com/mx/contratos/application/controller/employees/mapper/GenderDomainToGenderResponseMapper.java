package com.mx.contratos.application.controller.employees.mapper;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.response.GenderResponse;
import com.mx.contratos.domain.model.GenderDomain;

public class GenderDomainToGenderResponseMapper implements Mapper<GenderDomain, GenderResponse> {
	@Override
	public GenderResponse map(GenderDomain domain) {
		return new GenderResponse(
			domain.getId(),
			domain.getName()
		);
	}
}
