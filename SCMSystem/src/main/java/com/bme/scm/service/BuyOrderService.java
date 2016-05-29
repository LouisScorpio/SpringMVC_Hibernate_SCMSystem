package com.bme.scm.service;

import com.bme.scm.entity.BuyOrder;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */


public interface BuyOrderService extends BaseService<BuyOrder>{

	public int insertBuyOrder(BuyOrder buyOrder) throws Exception;
}
