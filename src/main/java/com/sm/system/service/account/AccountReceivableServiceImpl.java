package com.sm.system.service.account;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.domain.NumberCtrlRepository;
import com.sm.system.domain.accountant.AccountReceivable;
import com.sm.system.domain.accountant.AccountReceivableItem;
import com.sm.system.domain.accountant.AccountReceivableRepository;
import com.sm.system.domain.accountant.JournalVoucher;
import com.sm.system.domain.accountant.JournalVoucherItem;
import com.sm.system.domain.accountant.JournalVoucherRepository;
import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.exception.MyException;
import com.sm.system.service.parameter.ParameterService;
import com.sm.system.util.SystemUtil;

@Service("AccountReceivableService")
public class AccountReceivableServiceImpl implements AccountReceivableService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Resource(name="AccountReceivableRepository")
	private AccountReceivableRepository repository;
	@Resource(name="NumberCtrlService")
	private NumberCtrlService numberCtrlSvc;
	@Resource(name="ParameterServiceImpl")
	private ParameterService parameterSvc;
	
	@Override
	public List<AccountReceivable> findAll() {
		log.debug(".........get all AccountReceivable..............");
		return repository.findAll();
	}
	@Override
	public AccountReceivable findOne(String id) {
		AccountReceivable ar = repository.findOne(Integer.valueOf(id));
		if (ar == null) ar = new AccountReceivable();
		return ar;
	}
	
	@Override
	public AccountReceivable save(AccountReceivable ar) throws MyException {
		try {
			List<AccountReceivableItem> items = ar.getItems();
			for(AccountReceivableItem item: items){
				item.setAr(ar);
			}
			ar = repository.save(ar);
			if(ar.getVoucherNo() == null || ar.getVoucherNo().equals("")) {
				if(ar.getDate() == null) throw new MyException("Account Receivable Date cannot empty");
				// 获取 voucher number
				SystemParameter VoucherNoPrefix = parameterSvc.findByName("ACCOUNT-RECEIVABLE-NUMBER-PREFIX");
				ar.setVoucherNo(numberCtrlSvc.getNextNo(
						SystemUtil.isEmpty(VoucherNoPrefix.getKeyValue()) ? "AR" : VoucherNoPrefix.getKeyValue()
							, ar.getDate()));
				ar = repository.save(ar);
			}
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			throw new MyException("save account receivable error");
		}
		return ar;
	}
	
	
}
