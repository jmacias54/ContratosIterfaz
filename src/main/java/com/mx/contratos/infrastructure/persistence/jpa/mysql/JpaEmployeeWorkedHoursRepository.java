package com.mx.contratos.infrastructure.persistence.jpa.mysql;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.EmployeeWorkedHoursDomain;
import com.mx.contratos.domain.repository.EmployeeWorkedHoursRepository;
import com.mx.contratos.domain.use_case.worked_hours.add.EmployeeAddHoursInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;
import com.mx.contratos.infrastructure.persistence.jpa.repository.EmployeeRepositoryJpa;
import com.mx.contratos.infrastructure.persistence.jpa.repository.EmployeeWorkedHoursRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaEmployeeWorkedHoursRepository implements EmployeeWorkedHoursRepository {

	private final EmployeeWorkedHoursRepositoryJpa employeeWorkedHoursRepositoryJpa;
	private final EmployeeRepositoryJpa employeeRepositoryJpa;
	private final Mapper<EmployeeAddHoursInput, EmployeeWorkedHours> employeeAddHoursInputToEmployeeWorkedHoursMapper;
	private final Mapper<EmployeeWorkedHours, EmployeeWorkedHoursDomain> employeeWorkedHoursToEmployeeWorkedHoursDomainMapper;

	@Override
	public boolean WorkedDateAndEmployeeNonUnique(Date workedDate, long employeeId) {
		return Optional.ofNullable(
			this.employeeWorkedHoursRepositoryJpa.findByWorkedDateAndEmployee_Id(
				workedDate,
				employeeId
			)).isEmpty();
	}

	@Override
	public EmployeeWorkedHoursDomain create(EmployeeAddHoursInput input) {
		EmployeeWorkedHours entity = this.employeeAddHoursInputToEmployeeWorkedHoursMapper.map(input);
		entity.setEmployee(this.employeeRepositoryJpa.findById(input.getEmployeeId()).get());
		EmployeeWorkedHours entitySaved = this.employeeWorkedHoursRepositoryJpa.save(entity);
		return this.employeeWorkedHoursToEmployeeWorkedHoursDomainMapper.map(entitySaved);
	}
}
