package com.sm.system.domain.number;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("SystemSerialNumberRepository")
public interface SystemSerialNumberRepository extends JpaRepository<SystemSerialNumber, Integer>{

}
