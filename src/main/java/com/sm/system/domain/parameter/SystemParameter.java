package com.sm.system.domain.parameter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SystemParameter implements Serializable {

	public SystemParameter() {
		super();
	}
	public SystemParameter(String keyName, String keyType, String keyLenght, String keyValue, String comments) {
		super();
		this.keyName = keyName;
		this.keyType = keyType;
		this.keyLenght = keyLenght;
		this.keyValue = keyValue;
		this.comments = comments;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Integer id;
	@Column(nullable=false, unique=true)
	private String keyName;
	private String keyType;
	private String keyLenght;
	private String keyValue;
	private String comments;
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKeyType() {
		return this.keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public String getKeyLenght() {
		return this.keyLenght;
	}
	public void setKeyLenght(String keyLenght) {
		this.keyLenght = keyLenght;
	}
	public String getKeyValue() {
		return this.keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
	public String getComments() {
		return this.comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getKeyName() {
		return this.keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
}
