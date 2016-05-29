package com.bme.scm.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bme.scm.entity.AccountRecords;
import com.bme.scm.entity.BuyOrder;
import com.bme.scm.entity.BuyOrderDetail;
import com.bme.scm.service.BuyOrderService;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016年5月29日
 *
 */


@Service("buyOrderService")
public class BuyOrderServiceImpl extends BaseServiceImpl<BuyOrder> implements BuyOrderService{

	@Resource(name="buyOrder")
	private BuyOrder buyOrder;
	
	@Resource
	private AccountRecords accountRecords;
	
	@Override
	@Transactional
	public int insertBuyOrder(BuyOrder buyOrder) throws Exception {
		int i;
		String boId="bo"+UUID.randomUUID().toString().replace("-", "");
		System.out.println("boIduuid:"+boId);
		//设置采购单号
		buyOrder.setBoId(boId);
		for(BuyOrderDetail bod:buyOrder.getBuyOrderDetails()){
			bod.setBodId(UUID.randomUUID().toString().replace("-", ""));
			bod.setBodId(boId);
		}
		i = buyOrderDaoImpl.insert(buyOrder);

		// 生成并设置怅务记录的主键
		accountRecords.setArId(String.valueOf("ar"+UUID.randomUUID().toString().replace("-", "")));
		accountRecords.setArAttn(buyOrder.getBoAttn());
		accountRecords.setArArrears(buyOrder.getBoArrears());
		//bo表示商品采购，可以在参数表中加入相关内容
		accountRecords.setArBusType("bo");
		accountRecords.setArDate(buyOrder.getBoDate());
		//优惠金额：用应付金额减去实付金额再减去欠款
		accountRecords.setArDiscount(buyOrder.getBoPayable().subtract(buyOrder.getBoPaid()).subtract(buyOrder.getBoArrears()));
		accountRecords.setArOperator(buyOrder.getBoOperator());
		//采购单号
		accountRecords.setArOrderId(buyOrder.getBoId());
		accountRecords.setArPaid(buyOrder.getBoPaid());
		accountRecords.setArPayable(buyOrder.getBoPayable());
		accountRecords.setArRemark(buyOrder.getBoRemark());
		accountRecords.setSupplier(buyOrder.getSupplier());
        i=accountRecordsDaoImpl.insert(accountRecords); 
	
        return i;
	}

}
