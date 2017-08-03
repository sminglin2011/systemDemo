package com.sm.system.service.user;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sm.system.domain.user.SystemUser;
import com.sm.system.domain.user.UserRepository;

@Service("SystemUserServiceImpl")
public class SystemUserServiceImpl implements SystemUserService{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource(name="UserRepository")
	private UserRepository userRepository;

	@Override
	public SystemUser findByUsername(String username) {
		log.debug("findByUsername=" + username);
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
