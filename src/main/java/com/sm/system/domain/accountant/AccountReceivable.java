package com.sm.system.domain.accountant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.sm.system.domain.contact.ContactMaster;

@Entity
public class AccountReceivable implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String voucherNo;
	private Date date;
	private ChartOfAccount tradeDebit;
	private ContactMaster client;
	
	private String comments;
	
	private Double valueBase;
	private Double appliedAmount;
	@OneToMany(mappedBy="ar", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<AccountReceivableItem> items = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ChartOfAccount getTradeDebit() {
		return tradeDebit;
	}
	public void setTradeDebit(ChartOfAccount tradeDebit) {
		this.tradeDebit = tradeDebit;
	}
	public ContactMaster getClient() {
		return client;
	}
	public void setClient(ContactMaster client) {
		this.client = client;
	}
	public Double getValueBase() {
		return valueBase;
	}
	public void setValueBase(Double valueBase) {
		this.valueBase = valueBase;
	}
	public Double getAppliedAmount() {
		return appliedAmount;
	}
	public void setAppliedAmount(Double appliedAmount) {
		this.appliedAmount = appliedAmount;
	}
	public List<AccountReceivableItem> getItems() {
		return items;
	}
	public void setItems(List<AccountReceivableItem> items) {
		this.items = items;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
