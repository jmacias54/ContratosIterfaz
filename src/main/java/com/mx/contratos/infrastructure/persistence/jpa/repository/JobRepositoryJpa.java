package com.mx.contratos.infrastructure.persistence.jpa.repository;

import com.mx.contratos.infrastructure.persistence.jpa.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepositoryJpa extends JpaRepository<Job, Long> {
	boolean existsById(Long id);

}
