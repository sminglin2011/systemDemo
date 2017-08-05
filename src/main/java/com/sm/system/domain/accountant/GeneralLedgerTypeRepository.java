package com.sm.system.domain.accountant;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sm.system.constant.StaticParams;
import com.sm.system.util.SystemUtil;

@Repository("GeneralLedgerRepository")
public interface GeneralLedgerTypeRepository extends JpaRepository<GeneralLedgerType, Integer>{
	
	@Query("SELECT distinct(gl.classification) FROM GeneralLedgerType gl ")
    public Collection<String> findAllClassification();

}
