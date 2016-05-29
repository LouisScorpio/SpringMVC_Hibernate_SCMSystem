package com.bme.scm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bme.scm.dao.AccountDao;
import com.bme.scm.entity.Account;
import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */


@Repository
public class AccountDaoImpl implements AccountDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public int insert(Account entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(Account entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account select(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account login(Account account) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Account.class);
		criteria.add(Restrictions.eq("accLogin", account.getAccLogin()));
		criteria.add(Restrictions.eq("accPass", account.getAccPass()));
		Account accountResult=null;
		if(criteria.list().size()==1){
		accountResult = (Account) criteria.list().get(0);
		}
		return accountResult;
	}

	@Override
	public List<Account> selectPageList(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCount(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Account> selectPageListUseDyc(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCountUseDyc(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}



}
