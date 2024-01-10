package com.mx.contratos.infrastructure.persistence.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
@Data
@Accessors(chain = true)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "gender_id", nullable = false)
	private Gender gender;

	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;

	@Column(name = "name")
	private String name;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birthdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;

}
