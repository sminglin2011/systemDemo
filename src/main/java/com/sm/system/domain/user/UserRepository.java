package com.sm.system.domain.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<SystemUser, Integer>{

	SystemUser findByUsername(String username);
	@Query("select u from SystemUser u where u.id in(:ids)")
	List<SystemUser> findUsersByIds(String ids);
}
