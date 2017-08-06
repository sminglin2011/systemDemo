package com.sm.system.service.account;

import java.util.List;

import com.sm.system.domain.accountant.ChartOfAccount;
import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.exception.MyException;

public interface ChartOfAccountService {
	
	List<ChartOfAccount> findAll() throws MyException;
	
	ChartOfAccount findOne(String id);
	
	ChartOfAccount save(ChartOfAccount entity) throws MyException;
}
