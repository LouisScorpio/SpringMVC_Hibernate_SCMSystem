package com.bme.scm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name="buy_order")
public class BuyOrder implements Serializable {

	public List<BuyOrderDetail> getBuyOrderDetails() {
		return buyOrderDetails;
	}

	public void setBuyOrderDetails(List<BuyOrderDetail> buyOrderDetails) {
		this.buyOrderDetails = buyOrderDetails;
	}

	private static final long serialVersionUID = -7240532727035120051L;

	@Id
	@Column(name="bo_id")
	private String boId;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="sup_id")
    private Supplier supplier;

	
	@Column(name="sh_id")
    private String shId;

	@Column(name="bo_date")
    private Date boDate;

	@Column(name="bo_payable")
    private BigDecimal boPayable;

	@Column(name="bo_paid")
    private BigDecimal boPaid;

	@Column(name="bo_arrears")
    private BigDecimal boArrears;

	@Column(name="bo_original")
    private String boOriginal;

	@Column(name="bo_remark")
    private String boRemark;

	@Column(name="bo_attn")
    private String boAttn;

	@Column(name="bo_operator")
    private Integer boOperator;
    

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="bo_id")
    public List<BuyOrderDetail> buyOrderDetails;



	@Override
	public String toString() {
		return "BuyOrder [boId=" + boId + ", supId=" + supplier.getSupId() + ", shId=" + shId
				+ ", boDate=" + boDate + ", boPayable=" + boPayable
				+ ", boPaid=" + boPaid + ", boArrears=" + boArrears
				+ ", boOriginal=" + boOriginal + ", boRemark=" + boRemark
				+ ", boAttn=" + boAttn + ", boOperator=" + boOperator
				+ ", buyOrderDetails=" + buyOrderDetails + "]";
	}

	public String getBoId() {
        return boId;
    }

    public void setBoId(String boId) {
        this.boId = boId;
    }

   

    public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId;
    }

    public Date getBoDate() {
        return boDate;
    }

    public void setBoDate(Date boDate) {
        this.boDate = boDate;
    }

    public BigDecimal getBoPayable() {
        return boPayable;
    }

    public void setBoPayable(BigDecimal boPayable) {
        this.boPayable = boPayable;
    }

    public BigDecimal getBoPaid() {
        return boPaid;
    }

    public void setBoPaid(BigDecimal boPaid) {
        this.boPaid = boPaid;
    }

    public BigDecimal getBoArrears() {
        return boArrears;
    }

    public void setBoArrears(BigDecimal boArrears) {
        this.boArrears = boArrears;
    }

    public String getBoOriginal() {
        return boOriginal;
    }

    public void setBoOriginal(String boOriginal) {
        this.boOriginal = boOriginal;
    }

    public String getBoRemark() {
        return boRemark;
    }

    public void setBoRemark(String boRemark) {
        this.boRemark = boRemark;
    }

    public String getBoAttn() {
        return boAttn;
    }

    public void setBoAttn(String boAttn) {
        this.boAttn = boAttn;
    }

    public Integer getBoOperator() {
        return boOperator;
    }

    public void setBoOperator(Integer boOperator) {
        this.boOperator = boOperator;
    }
}