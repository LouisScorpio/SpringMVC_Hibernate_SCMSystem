package com.bme.scm.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="SUPPLIER")
public class Supplier implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3051147093149131879L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUP_ID")
	private Integer supId;

	@Column(name="SUP_NAME",length=50)
	private String supName;

	@Column(name="SUP_LINKNAME",length=50)
	private String supLinkman;

	@Column(name="SUP_PHONE",length=50)
	private String supPhone;

	@Column(name="SUP_ADDRESS",length=100)
	private String supAddress;

	@Column(name="SUP_REMARK",length=50)
	private String supRemark;
	
	@Column(name="SUP_PAY")
	private BigDecimal supPay;
	
	@Column(name="SUP_TYPE",length=50)
	private String supType;

	public BigDecimal getSupPay() {
		return supPay;
	}

	public void setSupPay(BigDecimal supPay) {
		this.supPay = supPay;
	}

	public String getSupType() {
		return supType;
	}

	public void setSupType(String supType) {
		this.supType = supType;
	}

	public Integer getSupId() {
		return supId;
	}

	public void setSupId(Integer supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public String getSupLinkman() {
		return supLinkman;
	}

	public void setSupLinkman(String supLinkman) {
		this.supLinkman = supLinkman;
	}

	public String getSupPhone() {
		return supPhone;
	}

	public void setSupPhone(String supPhone) {
		this.supPhone = supPhone;
	}

	public String getSupAddress() {
		return supAddress;
	}

	public void setSupAddress(String supAddress) {
		this.supAddress = supAddress;
	}

	public String getSupRemark() {
		return supRemark;
	}

	public void setSupRemark(String supRemark) {
		this.supRemark = supRemark;
	}

	@Override
	public String toString() {
		return "Supplier [supId=" + supId + ", supName=" + supName
				+ ", supLinkman=" + supLinkman + ", supPhone=" + supPhone
				+ ", supAddress=" + supAddress + ", supRemark=" + supRemark
				+ ", supPay=" + supPay + ", supType=" + supType + "]";
	}

}