package com.mx.contratos.infrastructure.persistence.jpa.mysql;

import com.mx.contratos.application.contract.Mapper;
import com.mx.contratos.domain.model.EmployeeDomain;
import com.mx.contratos.domain.repository.EmployeeRepository;
import com.mx.contratos.domain.use_case.employee.create.EmployeeCreateInput;
import com.mx.contratos.infrastructure.persistence.jpa.entity.Employee;
import com.mx.contratos.infrastructure.persistence.jpa.repository.EmployeeRepositoryJpa;
import com.mx.contratos.infrastructure.persistence.jpa.repository.GenderRepositoryJpa;
import com.mx.contratos.infrastructure.persistence.jpa.repository.JobRepositoryJpa;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class JpaEmployeeRepository implements EmployeeRepository {

	private final EmployeeRepositoryJpa employeeRepositoryJpa;
	private final GenderRepositoryJpa genderRepositoryJpa;
	private final JobRepositoryJpa jobRepositoryJpa;
	private final Mapper<EmployeeCreateInput, Employee> employeeCreateInputToEmployeeMapper;
	private final Mapper<Employee, EmployeeDomain> employeeToEmployeeDomainMapper;

	@Override
	public boolean nameAndLastnameIsUnique(String name, String lastName) {
		return Optional.ofNullable(this.employeeRepositoryJpa.findByNameAndLastName(name, lastName)).isEmpty();
	}


	@Override
	public boolean exists(Long userId) {
		Optional<Employee> employee = this.employeeRepositoryJpa.findById(userId);
		return Optional.ofNullable(employee).isEmpty();
	}

	@Override
	public EmployeeDomain create(EmployeeCreateInput input) {
		Employee employee = this.employeeCreateInputToEmployeeMapper.map(input);
		employee.setJob(this.jobRepositoryJpa.findById(input.getJobId()).get());
		employee.setGender(this.genderRepositoryJpa.findById(input.getGenderId()).get());

		Employee employeeSaved = this.employeeRepositoryJpa.save(employee);
		return this.employeeToEmployeeDomainMapper.map(employeeSaved);
	}

	@Override
	public List<EmployeeDomain> search(Long jobId) {

		return this.employeeRepositoryJpa.findAllByJobId(jobId)
			.stream()
			.map(this.employeeToEmployeeDomainMapper::map)
			.collect(
				Collectors.toList());
	}
}
