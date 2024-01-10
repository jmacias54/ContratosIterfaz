package com.mx.contratos.domain.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class EmployeeDomain {

	private final Long id;
}
