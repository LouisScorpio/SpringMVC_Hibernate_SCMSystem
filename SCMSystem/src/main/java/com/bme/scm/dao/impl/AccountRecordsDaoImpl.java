package com.bme.scm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bme.scm.dao.AccountRecordsDao;
import com.bme.scm.entity.AccountRecords;
import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */

@Repository
public class AccountRecordsDaoImpl implements AccountRecordsDao{

	@Resource
	private SessionFactory sessionFactory;
	@Override
	public int insert(AccountRecords entity) {
		return (int) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public int updateByPk(AccountRecords entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(AccountRecords entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AccountRecords select(AccountRecords entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountRecords> selectPageList(Page<AccountRecords> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCount(Page<AccountRecords> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<AccountRecords> selectPageListUseDyc(Page<AccountRecords> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCountUseDyc(Page<AccountRecords> page) {
		// TODO Auto-generated method stub
		return null;
	}

}
