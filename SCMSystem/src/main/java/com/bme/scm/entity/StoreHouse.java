package com.bme.scm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */

@Component
@Scope("prototype")
@Entity
@Table(name="store_house")
public class StoreHouse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sh_id")
	private String shId;
	
	@Column(name="sh_name")
	private String shName;
	
	@Column(name="sh_responsible")
	private String shResponsible;
	
	@Column(name="sh_phone")
	private String shPhone;
	
	@Column(name="sh_address")
	private String shAddress;
	
	@Column(name="sh_type")
	private String shType;
	
	@Column(name="sh_remark")
	private String shRemark;

	public String getShId() {
		return shId;
	}

	public void setShId(String shId) {
		this.shId = shId;
	}

	public String getShName() {
		return shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}

	public String getShResponsible() {
		return shResponsible;
	}

	public void setShResponsible(String shResponsible) {
		this.shResponsible = shResponsible;
	}

	public String getShPhone() {
		return shPhone;
	}

	public void setShPhone(String shPhone) {
		this.shPhone = shPhone;
	}

	public String getShAddress() {
		return shAddress;
	}

	public void setShAddress(String shAddress) {
		this.shAddress = shAddress;
	}

	public String getShType() {
		return shType;
	}

	public void setShType(String shType) {
		this.shType = shType;
	}

	public String getShRemark() {
		return shRemark;
	}

	public void setShRemark(String shRemark) {
		this.shRemark = shRemark;
	}
	
	
}
