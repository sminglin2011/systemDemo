package com.sm.system.service.account;

import java.util.List;

import com.sm.system.domain.accountant.AccountReceivable;
import com.sm.system.exception.MyException;

public interface AccountReceivableService {

	List<AccountReceivable> findAll();
	
	AccountReceivable findOne(String id);
	
	/**
	 * 先保存entity, 再做assign voucherNo。为了防止保存出现错误时失去一个号码，
	 * @param AccountReceivable
	 * @return
	 * @throws MyException
	 */
	AccountReceivable save(AccountReceivable ar) throws MyException;
}
