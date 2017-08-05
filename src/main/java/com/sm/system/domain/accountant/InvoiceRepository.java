package com.sm.system.domain.accountant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("InvoiceRepository")
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
