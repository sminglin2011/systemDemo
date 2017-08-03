package com.sm.system.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<SystemUser, Integer>{

	SystemUser findByUsername(String username);
}
