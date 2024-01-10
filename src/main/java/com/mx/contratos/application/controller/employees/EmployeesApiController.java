package com.mx.contratos.application.controller.employees;


import com.mx.contratos.application.configuration.constant.GlobalConstants;
import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.application.controller.employees.request.EmployeeAddHoursRequest;
import com.mx.contratos.application.controller.employees.request.EmployeeCreateRequest;
import com.mx.contratos.application.controller.employees.request.EmployeeFindByJobRequest;
import com.mx.contratos.application.controller.employees.request.EmployeeGetWorkedHoursRequest;
import com.mx.contratos.application.controller.employees.response.*;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateUseCase;
import com.mx.contratos.domain.use_case.employee.list.EmployeeSearchUseCase;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursUseCase;
import com.mx.contratos.domain.use_case.worked_hours.search.WorkedHoursSearchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = GlobalConstants.EMPLOYEES_ENDPOINT, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeesApiController {

	private final Mapper<EmployeeDomain, EmployeeResponse> employeeDomainToEmployeeResponseMapper;
	private final Mapper<EmployeeCreateRequest, EmployeeCreateInput> employeeCreateRequestToEmployeeCreateInputMapper;
	private final Mapper<EmployeeAddHoursRequest, EmployeeAddHoursInput> employeeAddHoursRequestToEmployeeAddHoursInputMapper;
	private final EmployeeCreateUseCase employeeCreateUseCase;
	private final EmployeeAddHoursUseCase employeeAddHoursUseCase;
	private final EmployeeSearchUseCase employeeSearchUseCase;
	private final WorkedHoursSearchUseCase workedHoursSearchUseCase;


	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeCreateResponse> create(@RequestBody @Valid EmployeeCreateRequest request) {

		EmployeeDomain domain = this.employeeCreateUseCase.execute(
			this.employeeCreateRequestToEmployeeCreateInputMapper.map(request)
		);
		return ResponseEntity.ok(new EmployeeCreateResponse(domain.getId(), Boolean.TRUE));
	}

	@PostMapping(path = "/addHours", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeAddHoursResponse> addHours(@RequestBody @Valid EmployeeAddHoursRequest request) {

		EmployeeWorkedHoursDomain domain = this.employeeAddHoursUseCase.execute(
			this.employeeAddHoursRequestToEmployeeAddHoursInputMapper.map(request)
		);
		return ResponseEntity.ok(new EmployeeAddHoursResponse(domain.getId(), Boolean.TRUE));
	}

	@PostMapping(path = "/findByJob", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeFindByJobResponse> findByJob(@RequestBody @Valid EmployeeFindByJobRequest request) {

		List<EmployeeDomain> domainList = this.employeeSearchUseCase.execute(request.getJobId());

		return ResponseEntity.ok(
			new EmployeeFindByJobResponse()
				.setEmployees(domainList.stream()
					.map(this.employeeDomainToEmployeeResponseMapper::map)
					.collect(Collectors.toList())));
	}

	@PostMapping(path = "/getWorkedHours", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeGetWorkedHoursResponse> getWorkedHours(@RequestBody @Valid EmployeeGetWorkedHoursRequest request) {
		return ResponseEntity.ok(
			new EmployeeGetWorkedHoursResponse(
				this.workedHoursSearchUseCase.execute(
					request.getEmployeeId(),
					request.getStartDate(),
					request.getEndDate()
				), Boolean.TRUE));
	}
}
