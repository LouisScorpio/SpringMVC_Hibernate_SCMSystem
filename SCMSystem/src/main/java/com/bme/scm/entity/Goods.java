package com.bme.scm.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name="goods")
public class Goods implements Serializable {
    @Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsUnit=" + goodsUnit + ", goodsType=" + goodsType
				+ ", goodsColor=" + goodsColor + ", goodsStore=" + goodsStore
				+ ", goodsLimit=" + goodsLimit + ", goodsCommission="
				+ goodsCommission + ", goodsProducer=" + goodsProducer
				+ ", goodsRemark=" + goodsRemark + ", goodsSelPrice="
				+ goodsSelPrice + ", goodsBuyPrice=" + goodsBuyPrice + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7686010924263973740L;

	@Id
	@Column(name="goods_Id",length=36)
	private String goodsId;

	
	@Column(name="goods_name",length=20)
    private String goodsName;

	
	@Column(name="goods_unit",length=10)
    private String goodsUnit;

	
	@Column(name="goods_type",length=10)
    private String goodsType;

	
	@Column(name="goods_color",length=10)
    private String goodsColor;

	
	@Column(name="goods_store")
    private Integer goodsStore;

	
	@Column(name="goods_limit")
    private Integer goodsLimit;

	
	@Column(name="goods_commission")
    private BigDecimal goodsCommission;

	
	@Column(name="goods_producer",length=50)
    private String goodsProducer;

	@Column(name="goods_remark",length=100)
    private String goodsRemark;

	@Column(name="goods_sel_price")
    private BigDecimal goodsSelPrice;

	@Column(name="goods_buy_price")
    private BigDecimal goodsBuyPrice;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public Integer getGoodsStore() {
        return goodsStore;
    }

    public void setGoodsStore(Integer goodsStore) {
        this.goodsStore = goodsStore;
    }

    public Integer getGoodsLimit() {
        return goodsLimit;
    }

    public void setGoodsLimit(Integer goodsLimit) {
        this.goodsLimit = goodsLimit;
    }

    public BigDecimal getGoodsCommission() {
        return goodsCommission;
    }

    public void setGoodsCommission(BigDecimal goodsCommission) {
        this.goodsCommission = goodsCommission;
    }

    public String getGoodsProducer() {
        return goodsProducer;
    }

    public void setGoodsProducer(String goodsProducer) {
        this.goodsProducer = goodsProducer;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark;
    }

    public BigDecimal getGoodsSelPrice() {
        return goodsSelPrice;
    }

    public void setGoodsSelPrice(BigDecimal goodsSelPrice) {
        this.goodsSelPrice = goodsSelPrice;
    }

    public BigDecimal getGoodsBuyPrice() {
        return goodsBuyPrice;
    }

    public void setGoodsBuyPrice(BigDecimal goodsBuyPrice) {
        this.goodsBuyPrice = goodsBuyPrice;
    }
}