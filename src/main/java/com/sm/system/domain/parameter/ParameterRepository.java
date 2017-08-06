package com.sm.system.domain.parameter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ParameterRepository")
public interface ParameterRepository extends JpaRepository<SystemParameter, Integer>{

	SystemParameter findByKeyName(String name);
}
