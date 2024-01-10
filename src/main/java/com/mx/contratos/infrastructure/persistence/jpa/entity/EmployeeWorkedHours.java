package com.mx.contratos.infrastructure.persistence.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_worked_hours")
@Data
@Accessors(chain = true)
public class EmployeeWorkedHours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;

	@Column(name = "worked_hours")
	private Long workedHours;

	@Column(name = "worked_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date workedDate;

}
