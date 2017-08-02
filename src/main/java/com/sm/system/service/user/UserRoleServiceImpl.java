package com.sm.system.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sm.system.domain.user.SystemUser;
import com.sm.system.domain.user.UserRole;
@Service("UserRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService{

	@Override
	public List<UserRole> getRoleByUser(SystemUser user) {
		// TODO Auto-generated method stub
		return null;
	}

}
