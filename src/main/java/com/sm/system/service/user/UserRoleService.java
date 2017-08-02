package com.sm.system.service.user;

import java.util.List;

import com.sm.system.domain.user.SystemUser;
import com.sm.system.domain.user.UserRole;

public interface UserRoleService {

	public List<UserRole> getRoleByUser(SystemUser user);
}
