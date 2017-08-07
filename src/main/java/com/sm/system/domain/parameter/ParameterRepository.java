package com.sm.system.domain.parameter;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ParameterRepository")
public interface ParameterRepository extends JpaRepository<SystemParameter, Integer>{

	SystemParameter findByKeyName(String name);
	
	@Query("SELECT distinct(p.keyName) FROM SystemParameter p ")
    public Collection<String> findAllKeyName();
	
	@Query("SELECT p.keyName, p.keyType, p.keyLenght FROM SystemParameter p ")
    public Collection<Object[]> findAllKey();
	
}
