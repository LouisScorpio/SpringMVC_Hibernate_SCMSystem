package com.bme.scm.service;

import com.bme.scm.entity.Account;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */


public interface AccountService extends BaseService<Account> {
	 public Account login(Account account);
}
