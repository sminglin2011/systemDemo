package com.sm.system.domain.accountant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class GeneralLedgerType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length=5, nullable=false, unique=true)
	private String clazz;
	
	private String classification;
	private String Name;
	private Integer ledgerFrom;
	private Integer ledgerTo;
	@Column(length=5)
	private String sequence;
	@OneToMany(mappedBy="ledgerType", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<ChartOfAccount> coas = new ArrayList<ChartOfAccount>();
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClazz() {
		return this.clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getClassification() {
		return this.classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getName() {
		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public Integer getLedgerFrom() {
		return this.ledgerFrom;
	}
	public void setLedgerFrom(Integer ledgerFrom) {
		this.ledgerFrom = ledgerFrom;
	}
	public Integer getLedgerTo() {
		return this.ledgerTo;
	}
	public void setLedgerTo(Integer ledgerTo) {
		this.ledgerTo = ledgerTo;
	}
	public String getSequence() {
		return this.sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public List<ChartOfAccount> getCoas() {
		return this.coas;
	}
	public void setCoas(List<ChartOfAccount> coas) {
		this.coas = coas;
	}
}
