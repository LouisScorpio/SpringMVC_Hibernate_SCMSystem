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
 * @Date     2016��5��29��
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
		//���òɹ�����
		buyOrder.setBoId(boId);
		for(BuyOrderDetail bod:buyOrder.getBuyOrderDetails()){
			bod.setBodId(UUID.randomUUID().toString().replace("-", ""));
			bod.setBodId(boId);
		}
		i = buyOrderDaoImpl.insert(buyOrder);

		// ���ɲ����������¼������
		accountRecords.setArId(String.valueOf("ar"+UUID.randomUUID().toString().replace("-", "")));
		accountRecords.setArAttn(buyOrder.getBoAttn());
		accountRecords.setArArrears(buyOrder.getBoArrears());
		//bo��ʾ��Ʒ�ɹ��������ڲ������м����������
		accountRecords.setArBusType("bo");
		accountRecords.setArDate(buyOrder.getBoDate());
		//�Żݽ���Ӧ������ȥʵ������ټ�ȥǷ��
		accountRecords.setArDiscount(buyOrder.getBoPayable().subtract(buyOrder.getBoPaid()).subtract(buyOrder.getBoArrears()));
		accountRecords.setArOperator(buyOrder.getBoOperator());
		//�ɹ�����
		accountRecords.setArOrderId(buyOrder.getBoId());
		accountRecords.setArPaid(buyOrder.getBoPaid());
		accountRecords.setArPayable(buyOrder.getBoPayable());
		accountRecords.setArRemark(buyOrder.getBoRemark());
		accountRecords.setSupplier(buyOrder.getSupplier());
        i=accountRecordsDaoImpl.insert(accountRecords); 
	
        return i;
	}

}
