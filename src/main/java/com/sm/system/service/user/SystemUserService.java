package com.sm.system.service.user;

import java.text.ParseException;
import java.util.List;

import com.sm.system.domain.user.SystemUser;
import com.sm.system.exception.MyException;

public interface SystemUserService {

	public SystemUser findByUsername(String username);
	
	List<SystemUser> findAll();
	
	SystemUser findOne(String id);
	
	SystemUser saveUser(SystemUser user) throws MyException;
	
	List<SystemUser> extendUser(String ids, String value) throws MyException;
}
