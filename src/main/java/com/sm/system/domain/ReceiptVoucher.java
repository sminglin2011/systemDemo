package com.sm.system.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.sm.system.domain.customer.Customer;

@Entity
public class ReceiptVoucher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Integer id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	private String paymentType;
	private String bank;
	private String referrence;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date chequeDate;
	private Double receivedAmount;
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPaymentType() {
		return this.paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getBank() {
		return this.bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getReferrence() {
		return this.referrence;
	}
	public void setReferrence(String referrence) {
		this.referrence = referrence;
	}
	public Date getChequeDate() {
		return this.chequeDate;
	}
	public void setChequeDate(Date chequeDate) {
		this.chequeDate = chequeDate;
	}
	public Double getReceivedAmount() {
		return this.receivedAmount;
	}
	public void setReceivedAmount(Double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	
}
