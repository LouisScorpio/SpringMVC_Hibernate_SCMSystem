package com.bme.scm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name="account_records")
public class AccountRecords implements Serializable {

	@Override
	public String toString() {
		return "AccountRecords [arId=" + arId + ", sup_id=" + supplier.getSupId()
				+ ", arDate=" + arDate + ", arOrderId=" + arOrderId
				+ ", arBusType=" + arBusType + ", arPayable=" + arPayable
				+ ", arPaid=" + arPaid + ", arArrears=" + arArrears
				+ ", arDiscount=" + arDiscount + ", arAttn=" + arAttn
				+ ", arOperator=" + arOperator + ", arRemark=" + arRemark + "]";
	}

	private static final long serialVersionUID = -3291957435350799337L;

	@Id
	@Column(name="ar_id")
	private String arId;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="sup_id")
    private Supplier supplier;

	@Column(name="ar_date")
    private Date arDate;

	@Column(name="ar_order_id")
    private String arOrderId;

	@Column(name="ar_bus_type")
    private String arBusType;

	@Column(name="ar_payable")
    private BigDecimal arPayable;

	@Column(name="ar_paid")
    private BigDecimal arPaid;

	@Column(name="ar_arrears")
    private BigDecimal arArrears;

	@Column(name="ar_discount")
    private BigDecimal arDiscount;

	@Column(name="ar_attn")
    private String arAttn;

	@Column(name="ar_operator")
    private Integer arOperator;

	@Column(name="ar_remark")
    private String arRemark;

    public String getArId() {
        return arId;
    }

    public void setArId(String arId) {
        this.arId = arId;
    }

   

    public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Date getArDate() {
        return arDate;
    }

    public void setArDate(Date arDate) {
        this.arDate = arDate;
    }

    public String getArOrderId() {
        return arOrderId;
    }

    public void setArOrderId(String arOrderId) {
        this.arOrderId = arOrderId;
    }

    public String getArBusType() {
        return arBusType;
    }

    public void setArBusType(String arBusType) {
        this.arBusType = arBusType;
    }

    public BigDecimal getArPayable() {
        return arPayable;
    }

    public void setArPayable(BigDecimal arPayable) {
        this.arPayable = arPayable;
    }

    public BigDecimal getArPaid() {
        return arPaid;
    }

    public void setArPaid(BigDecimal arPaid) {
        this.arPaid = arPaid;
    }

    public BigDecimal getArArrears() {
        return arArrears;
    }

    public void setArArrears(BigDecimal arArrears) {
        this.arArrears = arArrears;
    }

    public BigDecimal getArDiscount() {
        return arDiscount;
    }

    public void setArDiscount(BigDecimal arDiscount) {
        this.arDiscount = arDiscount;
    }

    public String getArAttn() {
        return arAttn;
    }

    public void setArAttn(String arAttn) {
        this.arAttn = arAttn;
    }

    public Integer getArOperator() {
        return arOperator;
    }

    public void setArOperator(Integer arOperator) {
        this.arOperator = arOperator;
    }

    public String getArRemark() {
        return arRemark;
    }

    public void setArRemark(String arRemark) {
        this.arRemark = arRemark;
    }
}