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
 * @Date     2016��5��29��
 *
 */


@SuppressWarnings("serial")
public class SysInitServlet extends HttpServlet{

	public void init() throws ServletException{
		//ϵͳ����
		Map<String, Object> sysParam=new HashMap<String, Object>();
		//��Ӧ������
		Map<String, String> supType=new HashMap<String, String>();
		supType.put("1", "��ͨ��Ӧ��");
		supType.put("2", "һ����Ӧ��");
		supType.put("3", "������Ӧ��");
		
		//��Ʒ��ɫ
		Map<String, String> goodsColor=new HashMap<String, String>();
	    goodsColor.put("red", "��ɫ");
	    goodsColor.put("green", "��ɫ");
	    goodsColor.put("blue", "��ɫ");
	    
	    sysParam.put("goodsColor", goodsColor);
	    sysParam.put("supType", supType);
	    ServletContext application=this.getServletContext();
	    application.setAttribute("sysParam", sysParam);
	    System.out.println("======��ʼ����ɣ��Ѽ��������ֵ�======-");
	
	}
}
