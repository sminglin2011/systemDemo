package com.sm.system.domain.accountant;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ChartOfAccount implements Serializable{

	public ChartOfAccount() {
		super();
	}
	public ChartOfAccount(Integer ledgerCode, String description, GeneralLedgerType ledgerType, String gstType,
			String currency) {
		super();
		this.ledgerCode = ledgerCode;
		this.description = description;
		this.ledgerType = ledgerType;
		this.gstType = gstType;
		this.currency = currency;
	}
	public ChartOfAccount(Integer id, Integer ledgerCode, String description, GeneralLedgerType ledgerType,
			String gstType, String currency, Boolean gstRevenue, Boolean retainEarning, Boolean debit, Boolean credit,
			Boolean inputGst, Boolean outputGst, String customReportLedgerCode, String customReportDescription) {
		super();
		this.id = id;
		this.ledgerCode = ledgerCode;
		this.description = description;
		this.ledgerType = ledgerType;
		this.gstType = gstType;
		this.currency = currency;
		this.gstRevenue = gstRevenue;
		this.retainEarning = retainEarning;
		this.debit = debit;
		this.credit = credit;
		this.inputGst = inputGst;
		this.outputGst = outputGst;
		this.customReportLedgerCode = customReportLedgerCode;
		this.customReportDescription = customReportDescription;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(length=5, nullable=false, unique=true)
	private Integer ledgerCode;
	private String description;
	@ManyToOne
	@JoinColumn(name="ledger_type_id")
	private GeneralLedgerType ledgerType;
	@Column(length=5)
	private String gstType;
	@Column(length=15)
	private String currency;
	private Boolean gstRevenue = false;
	private Boolean retainEarning = false;
	private Boolean debit = false;
	private Boolean credit = false;
	private Boolean inputGst = false;
	private Boolean outputGst = false;
	private String customReportLedgerCode;
	private String customReportDescription;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLedgerCode() {
		return this.ledgerCode;
	}
	public void setLedgerCode(Integer ledgerCode) {
		this.ledgerCode = ledgerCode;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public GeneralLedgerType getLedgerType() {
		return this.ledgerType;
	}
	public void setLedgerType(GeneralLedgerType ledgerType) {
		this.ledgerType = ledgerType;
	}
	public String getGstType() {
		return this.gstType;
	}
	public void setGstType(String gstType) {
		this.gstType = gstType;
	}
	public String getCurrency() {
		return this.currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Boolean getGstRevenue() {
		return this.gstRevenue;
	}
	public void setGstRevenue(Boolean gstRevenue) {
		this.gstRevenue = gstRevenue;
	}
	public Boolean getRetainEarning() {
		return this.retainEarning;
	}
	public void setRetainEarning(Boolean retainEarning) {
		this.retainEarning = retainEarning;
	}
	public String getCustomReportLedgerCode() {
		return this.customReportLedgerCode;
	}
	public void setCustomReportLedgerCode(String customReportLedgerCode) {
		this.customReportLedgerCode = customReportLedgerCode;
	}
	public String getCustomReportDescription() {
		return this.customReportDescription;
	}
	public void setCustomReportDescription(String customReportDescription) {
		this.customReportDescription = customReportDescription;
	}
	public Boolean getDebit() {
		return debit;
	}
	public void setDebit(Boolean debit) {
		this.debit = debit;
	}
	public Boolean getCredit() {
		return credit;
	}
	public void setCredit(Boolean credit) {
		this.credit = credit;
	}
	public Boolean getInputGst() {
		return inputGst;
	}
	public void setInputGst(Boolean inputGst) {
		this.inputGst = inputGst;
	}
	public Boolean getOutputGst() {
		return outputGst;
	}
	public void setOutputGst(Boolean outputGst) {
		this.outputGst = outputGst;
	}
	
}
