package com.bme.scm.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


@Controller
@RequestMapping("/buyOrder")
public class BuyOrderAction extends BaseAction{

	@Resource
	private BuyOrderService buyOrderService;
	
	@RequestMapping("/insertBuyOrder")
	@ResponseBody
	public Object insertBuyObject(String buyOrder){
		System.out.println("buyorderaction.rows��"+buyOrder);
	    int i=0;
	    try{
	    JSONObject object=JSONObject.fromObject(buyOrder);
	    BuyOrder bo = (BuyOrder) JSONObject.toBean(object,BuyOrder.class);
	    i=buyOrderService.insertBuyOrder(bo);
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    return i;
	}
	
	
	//ʹ��form���ύ��ʽ��action������
	@RequestMapping("/insertBuyOrderOnForm")
	@ResponseBody
	public Object insertBuyOrderOnForm(BuyOrder buyOrder,String rows) throws Exception{
		System.out.println("buyorderaction.buyOrder��"+buyOrder);
		System.out.println("buyorderaction.��json��Ϊ�ַ����Ĳɹ�����ϸ��"+rows);

		int i=0;
		try{
		JSONArray jsonArray = JSONArray.fromObject(rows);
		List<BuyOrderDetail> buyOrderDetails = (List<BuyOrderDetail>) JSONArray.toCollection(jsonArray, BuyOrderDetail.class);
	    buyOrder.setBuyOrderDetails(buyOrderDetails);
	    i=buyOrderService.insertBuyOrder(buyOrder);
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
}
