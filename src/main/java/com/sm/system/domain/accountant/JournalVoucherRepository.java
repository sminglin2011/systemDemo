package com.sm.system.domain.accountant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("JournalVoucherRepository")
public interface JournalVoucherRepository extends JpaRepository<JournalVoucher, Integer>{

}
