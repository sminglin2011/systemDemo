package com.sm.system.domain.accountant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.sm.system.domain.customer.Customer;

@Entity
public class Invoice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String docType; // invoice or debit note
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
//	private DeliveryAddress deliveryAddress;
	private String attention;
	private String Address;
	private String floor;
	private String unit;
	private String postcalCode;
	private String country;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	private String yourReferrence;
	private String ourReferrence;
	private String salesMan;
	private String salesGroup;
	private String terms;
	@Column(nullable=false)
	private Integer debitLedger; //trade debitor
	@OneToMany(mappedBy="invoice", cascade= {CascadeType.ALL})
	private List<InvoiceItem> items = new ArrayList<>();
	private Double totalAmount;
	private Double gstRate;
	private Double gstAmount;
	private Boolean includeGst = false;
	private Double grandTotal;
	private Double receivedAmount;
	private Double agingAmount;
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDocType() {
		return this.docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getAttention() {
		return this.attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getAddress() {
		return this.Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getFloor() {
		return this.floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getUnit() {
		return this.unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPostcalCode() {
		return this.postcalCode;
	}
	public void setPostcalCode(String postcalCode) {
		this.postcalCode = postcalCode;
	}
	public String getCountry() {
		return this.country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getYourReferrence() {
		return this.yourReferrence;
	}
	public void setYourReferrence(String yourReferrence) {
		this.yourReferrence = yourReferrence;
	}
	public String getOurReferrence() {
		return this.ourReferrence;
	}
	public void setOurReferrence(String ourReferrence) {
		this.ourReferrence = ourReferrence;
	}
	public String getSalesMan() {
		return this.salesMan;
	}
	public void setSalesMan(String salesMan) {
		this.salesMan = salesMan;
	}
	public String getSalesGroup() {
		return this.salesGroup;
	}
	public void setSalesGroup(String salesGroup) {
		this.salesGroup = salesGroup;
	}
	public String getTerms() {
		return this.terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public Integer getDebitLedger() {
		return this.debitLedger;
	}
	public void setDebitLedger(Integer debitLedger) {
		this.debitLedger = debitLedger;
	}
	public List<InvoiceItem> getItems() {
		return this.items;
	}
	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}
	public Double getTotalAmount() {
		double subAmount = 0;
		for(InvoiceItem item: this.items) {
			subAmount = subAmount + item.getTotalAmount();
		}
		return subAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		double subAmount = 0;
		for(InvoiceItem item: this.items) {
			subAmount = subAmount + item.getTotalAmount();
		}
		this.totalAmount = subAmount;
	}
	public Double getGstRate() {
		return this.gstRate;
	}
	public void setGstRate(Double gstRate) {
		this.gstRate = gstRate;
	}
	public Double getGstAmount() {
		double gst = 0;
		if (this.includeGst) {
			gst = (this.totalAmount / (this.gstRate + 100) * 0.01 ) * (this.gstRate * 0.01);
		} else {
			gst = this.gstRate * 0.01 * this.totalAmount;
		}
		return gst;
	}
	public void setGstAmount(Double gstAmount) {
		double gst = 0;
		if (this.includeGst) {
			gst = (this.totalAmount / (this.gstRate + 100) * 0.01 ) * (this.gstRate * 0.01);
		} else {
			gst = this.gstRate * 0.01 * this.totalAmount;
		}
		this.gstAmount = gst;
	}
	public Boolean getIncludeGst() {
		return this.includeGst;
	}
	public void setIncludeGst(Boolean includeGst) {
		this.includeGst = includeGst;
	}
	public Double getGrandTotal() {
		return this.totalAmount + this.gstAmount;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = this.totalAmount + this.gstAmount;;
	}
	public Double getReceivedAmount() {
		return this.receivedAmount;
	}
	public void setReceivedAmount(Double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}
	public Double getAgingAmount() {
		return this.grandTotal - this.receivedAmount;
	}
	public void setAgingAmount(Double agingAmount) {
		this.agingAmount = this.grandTotal - this.receivedAmount;
	}
	
	
}
