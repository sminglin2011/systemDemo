package com.sm.system.service.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.constant.StaticParams;
import com.sm.system.domain.accountant.ChartOfAccount;
import com.sm.system.domain.accountant.ChartOfAccountRepository;
import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.domain.accountant.GeneralLedgerTypeRepository;
import com.sm.system.exception.MyException;
import com.sm.system.util.CollectionUtil;

@Service("coaService")
public class ChartOfAccountServiceImpl implements ChartOfAccountService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="ChartOfAccountRepository")
	private ChartOfAccountRepository repository;

	@Override
	public List<ChartOfAccount> findAll() throws MyException{
		return repository.findAll();
	}

	@Override
	public ChartOfAccount save(ChartOfAccount entity) throws MyException {
		try {
			entity = repository.save(entity);
		} catch (RuntimeException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			if(e.getMessage().indexOf("[UK_") > 0) {
				throw new MyException("Duplicate Ledger Code");
			} else {
				throw new MyException(e.getLocalizedMessage());
			}
			
		}
		return entity;
	}

	@Override
	public ChartOfAccount findOne(String id) {
		ChartOfAccount coa = repository.findOne(Integer.valueOf(id));
		return coa;
	}
	
}
