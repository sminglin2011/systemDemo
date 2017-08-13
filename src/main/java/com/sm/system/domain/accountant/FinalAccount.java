package com.sm.system.domain.accountant;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class FinalAccount implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private ChartOfAccount coa;
	
	private Double closeAmount;
	
	private Double afterAjustAmount;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date closeDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ChartOfAccount getCoa() {
		return coa;
	}

	public void setCoa(ChartOfAccount coa) {
		this.coa = coa;
	}

	public Double getCloseAmount() {
		return closeAmount;
	}

	public void setCloseAmount(Double closeAmount) {
		this.closeAmount = closeAmount;
	}

	public Double getAfterAjustAmount() {
		return afterAjustAmount;
	}

	public void setAfterAjustAmount(Double afterAjustAmount) {
		this.afterAjustAmount = afterAjustAmount;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
}
