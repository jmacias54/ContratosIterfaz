package com.mx.contratos.infrastructure.persistence.jpa.repository;

import com.mx.contratos.infrastructure.persistence.jpa.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenderRepositoryJpa extends JpaRepository<Gender, Long> {

	boolean existsById(Long id);

}
