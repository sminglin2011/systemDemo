package com.sm.system.service.parameter;

import java.util.List;

import com.sm.system.domain.parameter.SystemParameter;
import com.sm.system.exception.MyException;

public interface ParameterService {
	
	boolean initParameter();
	
	SystemParameter save(SystemParameter entity);
	
	SystemParameter update(String id, String value) throws MyException;

	List<SystemParameter> save(List<SystemParameter> entitys);
	
	List<SystemParameter> findAll();
	
	void deleteAll();
}
