package com.sm.system.service.account;

import java.util.List;

import com.sm.system.domain.accountant.JournalVoucher;
import com.sm.system.exception.MyException;

public interface JournalVoucherService {

	List<JournalVoucher> findAll();
	
	JournalVoucher findOne(String id);
	
	/**
	 * 先保存entity, 再做assign voucherNo。为了防止保存出现错误时失去一个号码，
	 * @param journal
	 * @return
	 * @throws MyException
	 */
	JournalVoucher save(JournalVoucher journal) throws MyException;
}
