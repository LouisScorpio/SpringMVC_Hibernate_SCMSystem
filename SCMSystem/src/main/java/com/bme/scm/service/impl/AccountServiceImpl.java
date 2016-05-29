package com.bme.scm.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bme.scm.entity.Account;
import com.bme.scm.service.AccountService;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */


@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	/*
	@Resource
	private AccountDaoImpl accountDaoImpl;
	*/
/*
	@Override
	public int insert(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account select(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	@Transactional
	public Account login(Account account) {
		// TODO Auto-generated method stub
		return accountDaoImpl.login(account);
	}
/*
	@Override
	public Page<Account> selectPage(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<Account> selectPageUseDyc(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

*/

}
