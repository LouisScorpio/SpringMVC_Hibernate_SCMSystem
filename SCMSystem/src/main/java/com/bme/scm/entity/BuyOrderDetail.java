package com.bme.scm.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name="buy_order_detail")
public class BuyOrderDetail implements Serializable {

	@Override
	public String toString() {
		return "BuyOrderDetail [bodId=" + bodId + ", goodsId=" + goods.getGoodsId()
				+ ", goodsName=" + goods.getGoodsName() + ", goodsUnit=" + goods.getGoodsUnit()
				+ ", goodsType=" + goods.getGoodsType() + ", goodsColor=" + goods.getGoodsColor()
				+ ", bodAmount=" + bodAmount + ", bodBuyPrice=" + bodBuyPrice
				+ ", bodTotalPrice=" + bodTotalPrice + ", boId=" + boId
				+ ", bodImeiList=" + bodImeiList + "]";
	}

	private static final long serialVersionUID = -4001513144832388483L;

	@Id
	@Column(name="bod_id")
	private String bodId;

	@ManyToOne(fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="goods_id")
    private Goods goods;

	@Column(name="bod_amount")
    private Integer bodAmount;

	@Column(name="bod_buy_price")
    private BigDecimal bodBuyPrice;

	@Column(name="bod_total_price")
    private BigDecimal bodTotalPrice;

	
	@Column(name="bo_id")
    private BuyOrder boId;

	@Column(name="bod_imei_list")
    private String bodImeiList;

    public Integer getBodAmount() {
        return bodAmount;
    }

    public void setBodAmount(Integer bodAmount) {
        this.bodAmount = bodAmount;
    }

    public BigDecimal getBodBuyPrice() {
        return bodBuyPrice;
    }

    public void setBodBuyPrice(BigDecimal bodBuyPrice) {
        this.bodBuyPrice = bodBuyPrice;
    }

    public BigDecimal getBodTotalPrice() {
        return bodTotalPrice;
    }

    public void setBodTotalPrice(BigDecimal bodTotalPrice) {
        this.bodTotalPrice = bodTotalPrice;
    }

    public String getBodId() {
		return bodId;
	}

	public void setBodId(String bodId) {
		this.bodId = bodId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public BuyOrder getBoId() {
		return boId;
	}

	public void setBoId(BuyOrder boId) {
		this.boId = boId;
	}

	public String getBodImeiList() {
        return bodImeiList;
    }

    public void setBodImeiList(String bodImeiList) {
        this.bodImeiList = bodImeiList;
    }
}