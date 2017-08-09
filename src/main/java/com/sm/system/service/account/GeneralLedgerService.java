package com.sm.system.service.account;

import java.util.List;

import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.exception.MyException;

public interface GeneralLedgerService {
	
	List<GeneralLedgerType> findAll() throws MyException;
	
	GeneralLedgerType update(String id, String name, String sequence) throws MyException;
	
	/**
	 * 初始化 account, 默认系统ledgerType
	 */
	void initGeneralLedger() throws MyException;
	
	GeneralLedgerType findByClassification(String classification);

}
