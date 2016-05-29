package com.bme.scm.servlets;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016年5月29日
 *
 */


@SuppressWarnings("serial")
public class SysInitServlet extends HttpServlet{

	public void init() throws ServletException{
		//系统参数
		Map<String, Object> sysParam=new HashMap<String, Object>();
		//供应商类型
		Map<String, String> supType=new HashMap<String, String>();
		supType.put("1", "普通供应商");
		supType.put("2", "一级供应商");
		supType.put("3", "二级供应商");
		
		//商品颜色
		Map<String, String> goodsColor=new HashMap<String, String>();
	    goodsColor.put("red", "红色");
	    goodsColor.put("green", "绿色");
	    goodsColor.put("blue", "蓝色");
	    
	    sysParam.put("goodsColor", goodsColor);
	    sysParam.put("supType", supType);
	    ServletContext application=this.getServletContext();
	    application.setAttribute("sysParam", sysParam);
	    System.out.println("======初始化完成，已加载数据字典======-");
	
	}
}
