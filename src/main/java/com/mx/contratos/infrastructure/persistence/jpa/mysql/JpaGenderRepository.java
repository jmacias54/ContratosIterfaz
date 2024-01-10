package com.mx.contratos.infrastructure.persistence.jpa.mysql;

import com.mx.contratos.domain.repository.GenderRepository;
import com.mx.contratos.infrastructure.persistence.jpa.repository.GenderRepositoryJpa;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JpaGenderRepository implements GenderRepository {

	private final GenderRepositoryJpa genderRepositoryJpa;

	@Override
	public boolean exists(Long genderId) {
		return this.genderRepositoryJpa.existsById(genderId);
	}
}
