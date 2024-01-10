package com.mx.contratos.domain.use_case.worked_hours.add;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class EmployeeAddHoursInput {

	private final Long employeeId;
	private final Long workedHours;
	private final Date workedDate;
}
