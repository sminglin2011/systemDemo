package com.sm.system.service.account;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.sm.system.domain.accountant.ChartOfAccount;
import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.exception.MyException;

public interface NumberCtrlService {
	String getNextNo(String module, Date voucherDate) throws MyException;
}
