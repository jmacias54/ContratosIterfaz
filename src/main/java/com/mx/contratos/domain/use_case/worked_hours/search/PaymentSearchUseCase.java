package com.mx.contratos.domain.use_case.worked_hours.search;

import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.repository.EmployeeRepository;
import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class PaymentSearchUseCase {

	private final EmployeeWorkedHoursRepository employeeWorkedHoursRepository;
	private final EmployeeRepository employeeRepository;

	public BigDecimal execute(
		Long employeeId,
		Date startDate,
		Date endDate
	) {

		Long workedHoursTotal = this.employeeWorkedHoursRepository.findByEmployeeIdAndWorkedDateRange(
			employeeId,
			startDate,
			endDate
		);

		EmployeeDomain employeeDomain = this.employeeRepository.getById(employeeId);

		if(nonNull(employeeDomain))
			return new BigDecimal(workedHoursTotal).multiply(new BigDecimal(employeeDomain.getJob().getSalary()));

		return BigDecimal.ZERO;
	}
}
