package com.mx.contratos.infrastructure.persistence.jpa.repository;

import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeWorkedHoursRepositoryJpa extends JpaRepository<EmployeeWorkedHours, Long> {

	EmployeeWorkedHours findByWorkedDateAndEmployee_Id(Date workedDate, Long employeeId);

	@Query("SELECT e FROM EmployeeWorkedHours e " +
		"WHERE e.employee.id = :employeeId " +
		"AND e.workedDate BETWEEN :startDate AND :endDate")
	List<EmployeeWorkedHours> findByEmployeeIdAndWorkedDateRange(
		@Param("employeeId") Long employeeId,
		@Param("startDate") Date startDate,
		@Param("endDate") Date endDate
	);

}
