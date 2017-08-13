package com.sm.system.domain.contact;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ContactMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false, unique=true)
	private String name;
	private String email;
	private String attention;
	private String telephone;
	private String mobile;
	private String fax;
	private String address;
	private String postalCode;
	private String floor;
	private String unit;
	private Boolean client = false;
	private Boolean supplier = false;
	
//	@OneToMany(mappedBy="customer", fetch=FetchType.LAZY)
//	public Set<DeliveryAddress> deliveryAddress;
	
//	@OneToMany(mappedBy="customer")
//	public Set<TingkatOrder> tingkatOrders;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getClient() {
		return client;
	}
	public void setClient(Boolean client) {
		this.client = client;
	}
	public Boolean getSupplier() {
		return supplier;
	}
	public void setSupplier(Boolean supplier) {
		this.supplier = supplier;
	}
	
}
