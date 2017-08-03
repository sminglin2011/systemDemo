package com.sm.system.service.parameter;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.domain.parameter.ParameterRepository;
import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.exception.MyException;
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

}
