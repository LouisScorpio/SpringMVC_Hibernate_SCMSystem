package com.bme.scm.action;

import javax.annotation.Resource;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bme.scm.entity.Account;
import com.bme.scm.service.AccountService;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */


@Controller
@RequestMapping("/account")
public class AccountAction extends BaseAction {
@Resource
private AccountService accountService;

@RequestMapping("/login")
	public String login(Account account,HttpServletRequest request,HttpSession session){
		System.out.println("����action.account:"+account);
		Account acc=accountService.login(account);
		if(acc!=null){
			//��session
			session.setAttribute("account", acc);
			System.out.println(session.getAttribute("account"));
			return "/WEB-INF/main/main.jsp";
		}
		else {
			request.setAttribute("msg", "�û������������");
			return "forward:/login.jsp";
		}
	}
	
}
