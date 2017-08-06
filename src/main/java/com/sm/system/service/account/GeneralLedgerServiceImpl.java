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
import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.domain.accountant.GeneralLedgerTypeRepository;
import com.sm.system.exception.MyException;
import com.sm.system.util.CollectionUtil;

@Service("GeneralLedgerService")
public class GeneralLedgerServiceImpl implements GeneralLedgerService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="GeneralLedgerRepository")
	private GeneralLedgerTypeRepository repository;

	@Override
	public List<GeneralLedgerType> findAll() throws MyException{
		Collection<String> classificaitons = repository.findAllClassification();
		for(String s: classificaitons) {
			log.debug(".................what is it: s = " + s);
		}
		Collection<String> newClassification = CollectionUtil.getDiffentNoDuplicate(StaticParams.CLASSIFICATIONS, classificaitons);
		/**
		 * 如果手动在数据库general ledger type table加数据会一直重复insert to table
		 */
		List<GeneralLedgerType> list = new ArrayList<>();
		for(String s: newClassification) {
			GeneralLedgerType ledger = new GeneralLedgerType();
			ledger.setClassification(s);
			Random random = new Random();
			String tempString = String.format("%04d", random.nextInt(10000));
			log.debug(s + "=what is it math.random=" +tempString );
			ledger.setClazz("C"+tempString);
			ledger.setName(tempString);
			ledger.setSequence(tempString);
			list.add(ledger);
		}
		repository.save(list);
		return repository.findAll();
	}

	@Override
	public GeneralLedgerType update(String id, String name, String sequence) throws MyException{
		GeneralLedgerType ledger = repository.findOne(Integer.valueOf(id));
		if (name != null && !name.equals("")) {
			ledger.setName(name);
		}
		if (sequence != null && !sequence.equals("")) {
			ledger.setSequence(sequence);
		}	
		try {
			repository.save(ledger);
		} catch (RuntimeException e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			throw new MyException("Sequence Max length is 5 digits");
		}
		
		return ledger;
	}
	
	
}
