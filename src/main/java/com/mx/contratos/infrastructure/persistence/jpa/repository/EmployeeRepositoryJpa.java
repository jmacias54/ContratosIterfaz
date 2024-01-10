package com.mx.contratos.infrastructure.persistence.jpa.repository;


import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryJpa extends JpaRepository<Employee, Long> {

	Employee findByNameAndLastName(String name, String lastname);
}
