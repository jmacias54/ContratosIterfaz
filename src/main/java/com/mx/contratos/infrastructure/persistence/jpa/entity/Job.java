package com.mx.contratos.infrastructure.persistence.jpa.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Data
@Accessors(chain = true)
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "salary", precision = 9, scale = 2)
	private Double salary;

}

