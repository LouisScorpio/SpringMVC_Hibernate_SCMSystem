package com.bme.scm.dao;

import com.bme.scm.entity.Account;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */


public interface AccountDao extends BaseDao<Account> {
	public Account login(Account account);

}