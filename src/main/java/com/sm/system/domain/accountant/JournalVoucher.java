package com.sm.system.domain.accountant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class JournalVoucher implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	
	private String voucherNo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	private String debitDescription;
	private Integer debitLedger;
	private Double debitAmount;
	private String creditDescription;
	private Integer creditLedger;
	private Double creditAmount;
	private String comments;
	@OneToMany(mappedBy="journalVoucher", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<JournalVoucherItem> items = new ArrayList<>(); 
	private Boolean blocked;
	
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
	public Double getDebitAmount() {
//		double amount = 0;
//		for(JournalVoucherItem item : items) {
//			amount = amount + item.getDebit();
//		}
//		return amount;
		return this.debitAmount;
	}
	public void setDebitAmount(Double debitAmount) {
//		double amount = 0;
//		for(JournalVoucherItem item : items) {
//			amount = amount + item.getDebit();
//		}
		this.debitAmount = debitAmount;
	}
	public Double getCreditAmount() {
//		double amount = 0;
//		for(JournalVoucherItem item : this.items) {
//			amount = amount + item.getCredit();
//		}
//		return amount;
		return this.creditAmount;
	}
	public void setCreditAmount(Double creditAmount) {
//		double amount = 0;
//		for(JournalVoucherItem item : this.items) {
//			System.out.println(item.getId() + "===journal voucher items = " + items.size());
//			amount = amount + item.getCredit();
//		}
//		this.creditAmount = amount;
		this.creditAmount = creditAmount;
	}
	public String getComments() {
		return this.comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<JournalVoucherItem> getItems() {
		return this.items;
	}
	public void setItems(List<JournalVoucherItem> items) {
		this.items = items;
	}
	public String getVoucherNo() {
		return voucherNo;
	}
	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}
	public String getDebitDescription() {
		return this.debitDescription;
	}
	public void setDebitDescription(String debitDescription) {
		this.debitDescription = debitDescription;
	}
	public Integer getDebitLedger() {
		return this.debitLedger;
	}
	public void setDebitLedger(Integer debitLedger) {
		this.debitLedger = debitLedger;
	}
	public String getCreditDescription() {
		return this.creditDescription;
	}
	public void setCreditDescription(String creditDescription) {
		this.creditDescription = creditDescription;
	}
	public Integer getCreditLedger() {
		return this.creditLedger;
	}
	public void setCreditLedger(Integer creditLedger) {
		this.creditLedger = creditLedger;
	}
	public Boolean getBlocked() {
		return blocked;
	}
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}
}
