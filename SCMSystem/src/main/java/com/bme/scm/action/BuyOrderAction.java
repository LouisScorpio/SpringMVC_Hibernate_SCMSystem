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
 * @Date     2016年5月29日
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
		System.out.println("buyorderaction.rows："+buyOrder);
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
	
	
	//使用form表单提交方式的action处理方法
	@RequestMapping("/insertBuyOrderOnForm")
	@ResponseBody
	public Object insertBuyOrderOnForm(BuyOrder buyOrder,String rows) throws Exception{
		System.out.println("buyorderaction.buyOrder："+buyOrder);
		System.out.println("buyorderaction.把json作为字符串的采购单明细："+rows);

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
