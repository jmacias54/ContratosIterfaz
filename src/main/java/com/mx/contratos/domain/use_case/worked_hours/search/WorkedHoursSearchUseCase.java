package com.mx.contratos.domain.use_case.worked_hours.search;

import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class WorkedHoursSearchUseCase {

	private final EmployeeWorkedHoursRepository employeeWorkedHoursRepository;

	public Long execute(
		Long employeeId,
		Date startDate,
		Date endDate
	) {

		return this.employeeWorkedHoursRepository.findByEmployeeIdAndWorkedDateRange(
			employeeId,
			startDate,
			endDate
		);
	}
}
