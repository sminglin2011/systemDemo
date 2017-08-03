package com.sm.system.domain.accountant;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InvoiceItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="invoice_id")
	private Invoice invoice;
	private Integer ledgerCode;
	private String referrence;
	private String description;
	private Integer quantity;
	private String unitMs;
	private Double unitPrice;
	private Integer discountPercentage;
	private Double discountAmount;
	private Double totalAmount;
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Invoice getInvoice() {
		return this.invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Integer getLedgerCode() {
		return this.ledgerCode;
	}
	public void setLedgerCode(Integer ledgerCode) {
		this.ledgerCode = ledgerCode;
	}
	public String getReferrence() {
		return this.referrence;
	}
	public void setReferrence(String referrence) {
		this.referrence = referrence;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUnitMs() {
		return this.unitMs;
	}
	public void setUnitMs(String unitMs) {
		this.unitMs = unitMs;
	}
	public Double getUnitPrice() {
		return this.unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getDiscountPercentage() {
		return this.discountPercentage;
	}
	public void setDiscountPercentage(Integer discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Double getDiscountAmount() {
		return this.quantity * this.unitPrice * this.discountPercentage * 0.01;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = this.quantity * this.unitPrice * this.discountPercentage * 0.01;
	}
	public Double getTotalAmount() {
		return this.quantity * this.unitPrice - this.discountAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = this.quantity * this.unitPrice - this.discountAmount;
	}
	
}
