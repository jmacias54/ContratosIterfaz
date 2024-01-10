package com.mx.contratos.infrastructure.persistence.jpa.repository;

import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeeWorkedHoursRepositoryJpa extends JpaRepository<EmployeeWorkedHours, Long> {

	EmployeeWorkedHours findByWorkedDateAndEmployee_Id(Date workedDate, Long employeeId);

}
