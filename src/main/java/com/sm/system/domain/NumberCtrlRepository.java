package com.sm.system.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("NumberCtrlRepository")
public interface NumberCtrlRepository extends JpaRepository<NumberCtrl, Integer>{

	NumberCtrl findByPrefixAndPattern(String prefix, String pattern);
	
}
