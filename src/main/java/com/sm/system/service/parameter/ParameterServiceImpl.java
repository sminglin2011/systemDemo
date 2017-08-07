package com.sm.system.service.parameter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.constant.StaticParams;
import com.sm.system.domain.accountant.GeneralLedgerType;
import com.sm.system.domain.parameter.ParameterRepository;
import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.exception.MyException;
import com.sm.system.util.CollectionUtil;
@Service("ParameterServiceImpl")
public class ParameterServiceImpl implements ParameterService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="ParameterRepository")
	private ParameterRepository repository;
	
	@Override
	public SystemParameter save(SystemParameter entity) {
		return repository.save(entity);
	}

	@Override
	public List<SystemParameter> save(List<SystemParameter> entitys) {
		return repository.save(entitys);
	}
	
	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public boolean initParameter() {
		if (repository.count()<1) {
			return false;
		}
		return true;
	}

	@Override
	public List<SystemParameter> findAll() {
		return repository.findAll();
	}

	@Override
	public SystemParameter update(String id, String value) throws MyException {
		SystemParameter parameter = repository.findOne(Integer.valueOf(id));
		parameter.setKeyValue(value);
		try {
			repository.save(parameter);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			e.printStackTrace();
			throw new MyException("update parameter error");
		}
		
		return parameter;
	}

	@Override
	public SystemParameter findByName(String name) {
		return repository.findByKeyName(name);
	}

	@Override
	public void patchNewParameter() {
		Collection<Object[]> keyNames = repository.findAllKey();
		for(Object[] s: keyNames) {
			for(int i=0; i<s.length; i++) {
				log.debug(".................what is it: parameter keyName = " + s[i]);
			}
		}
//		Collection<String> newKeyNames = CollectionUtil.getDiffentNoDuplicate(StaticParams.SYSTEM_PARAMETER_KEYS, keyNames);
//		/**
//		 * 如果手动在数据库system parameter table加数据会一直重复insert to table
//		 */
//		List<SystemParameter> list = new ArrayList<>();
//		for(String s: newKeyNames) {
//			SystemParameter param = new SystemParameter();
//			param.setKeyName(s);
//			param.setKeyType("String");
//			param.setKeyLenght("50");
//			list.add(param);
//		}
//		repository.save(list);
	}

}
