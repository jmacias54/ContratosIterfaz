package com.mx.contratos.application.controller.employees;


import com.mx.contratos.application.configuration.constant.GlobalConstants;
import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.request.EmployeeCreateRequest;
import com.mx.contratos.application.controller.employees.request.EmployeeCreateResponse;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.EMPLOYEES_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeesApiController {

	private final Mapper<EmployeeCreateRequest, EmployeeCreateInput> employeeCreateRequestToEmployeeCreateInputMapper;
	private final EmployeeCreateUseCase employeeCreateUseCase;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeCreateResponse> create(@RequestBody @Valid EmployeeCreateRequest request) {

		EmployeeDomain domain = this.employeeCreateUseCase.execute(
			this.employeeCreateRequestToEmployeeCreateInputMapper.map(request)
		);
		return ResponseEntity.ok(new EmployeeCreateResponse(domain.getId(), Boolean.TRUE));
	}
}
