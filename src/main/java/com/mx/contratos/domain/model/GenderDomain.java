package com.mx.contratos.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GenderDomain {

	private final Long id;
	private final String name;
}
