package com.sm.system.domain.accountant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("AccountReceivableRepository")
public interface AccountReceivableRepository extends JpaRepository<AccountReceivable, Integer>{
	
	
}
