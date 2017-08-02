package com.sm.system.service.user;

import com.sm.system.domain.user.SystemUser;

public interface SystemUserService {

	public SystemUser findByUsername(String username);
}
