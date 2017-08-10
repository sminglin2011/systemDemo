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
		if(parameter.getKeyName().contains("SMSYSTEM_")) { //包含SMSYSTEM_在parameter都只能在初始化页面增加不能做修改
			return parameter;
		}
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
		Collection<String[]> newKeyNames = new ArrayList<>();
		log.debug("size >>>>>>" + newKeyNames.size());
		
		for(String[] s: StaticParams.SYSTEM_PARAMETER_KEYS) {
			log.debug("自定义取出来在 s[0].toString() = " + s[0].toString());
			boolean inString = false;
			for(Object[] o : keyNames){
				log.debug("数据库取出来在 o[0].toString() = " + o[0].toString());
				if (s[0].equals(o[0].toString())) {
					inString = true;
					break;
				}
			}
			if (!inString) {
				newKeyNames.add(s);
			}
		}
		/**
		 * 如果手动在数据库system parameter table加数据会一直重复insert to table
		 */
		List<SystemParameter> list = new ArrayList<>();
		for(String[] s: newKeyNames) {
			SystemParameter param = new SystemParameter();
			param.setKeyName(s[0]); //这里的下标顺序一定跟StaticParam里的顺序一样
			param.setKeyType(s[1]);
			param.setKeyLenght(s[2]);
			list.add(param);
		}
		repository.save(list);
	}

}
