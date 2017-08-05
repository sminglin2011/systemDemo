package com.sm.system.service.account;

import java.util.List;

import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.exception.MyException;

public interface GeneralLedgerService {
	
	List<GeneralLedgerType> findAll() throws MyException;
	
	GeneralLedgerType update(String id, String value) throws MyException;

}
