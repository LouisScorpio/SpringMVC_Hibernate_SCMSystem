package com.bme.scm.service;

import com.bme.scm.entity.Account;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */


public interface AccountService extends BaseService<Account> {
	 public Account login(Account account);
}
