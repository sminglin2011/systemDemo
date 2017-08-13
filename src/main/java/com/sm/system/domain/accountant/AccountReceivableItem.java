package com.sm.system.domain.accountant;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.sm.system.domain.contact.ContactMaster;

@Entity
public class AccountReceivableItem implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="ar_id")
	private AccountReceivable ar;
	
	private String refference;
	private Integer ledgerCode;
	private String description;
	private String remark;
	
	private Double quantity;
	private Double unitPrice;
	private Double discountPercentage;
	private Double valueBase;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AccountReceivable getAr() {
		return ar;
	}
	public void setAr(AccountReceivable ar) {
		this.ar = ar;
	}
	public String getRefference() {
		return refference;
	}
	public void setRefference(String refference) {
		this.refference = refference;
	}
	public Integer getLedgerCode() {
		return ledgerCode;
	}
	public void setLedgerCode(Integer ledgerCode) {
		this.ledgerCode = ledgerCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Double getValueBase() {
		return valueBase;
	}
	public void setValueBase(Double valueBase) {
		this.valueBase = valueBase;
	}
	
}
