package com.mx.contratos.infrastructure.persistence.jpa.repository;

import com.mx.contratos.infrastructure.persistence.jpa.entity.EmployeeWorkedHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeWorkedHoursRepositoryJpa extends JpaRepository<EmployeeWorkedHours, Long> {
}
