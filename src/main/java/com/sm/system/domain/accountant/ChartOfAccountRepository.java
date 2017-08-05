package com.sm.system.domain.accountant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ChartOfAccountRepository")
public interface ChartOfAccountRepository extends JpaRepository<ChartOfAccount, Integer>{

}
