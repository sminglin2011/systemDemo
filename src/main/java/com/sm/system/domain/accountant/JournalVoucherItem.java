package com.sm.system.domain.accountant;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JournalVoucherItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="journal_voucher_id")
	private JournalVoucher journalVoucher;
	@Column(length=5)
	private String subType;
	@Column(length=5)
	private Integer ledgerCode;
	private String referenceType;
	private String description;
	private Double debit;
	private Double credit;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public JournalVoucher getJournalVoucher() {
		return this.journalVoucher;
	}
	public void setJournalVoucher(JournalVoucher journalVoucher) {
		this.journalVoucher = journalVoucher;
	}
	public String getSubType() {
		return this.subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public Integer getLedgerCode() {
		return this.ledgerCode;
	}
	public void setLedgerCode(Integer ledgerCode) {
		this.ledgerCode = ledgerCode;
	}
	public String getReferenceType() {
		return this.referenceType;
	}
	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getDebit() {
		return this.debit;
	}
	public void setDebit(Double debit) {
		this.debit = debit;
	}
	public Double getCredit() {
		return this.credit;
	}
	public void setCredit(Double credit) {
		this.credit = credit;
	}
}
