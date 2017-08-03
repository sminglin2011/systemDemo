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
	private Boolean gstRevenue;
	private Boolean retainEarning;
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
	
}
