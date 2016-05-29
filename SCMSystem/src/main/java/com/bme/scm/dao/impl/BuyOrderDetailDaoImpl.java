package com.bme.scm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bme.scm.dao.BuyOrderDetailDao;
import com.bme.scm.entity.BuyOrderDetail;
import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */

@Repository
public class BuyOrderDetailDaoImpl implements BuyOrderDetailDao{

	@Resource
	private SessionFactory sessionFactory;
	@Override
	public int insert(BuyOrderDetail entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(BuyOrderDetail entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BuyOrderDetail entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BuyOrderDetail select(BuyOrderDetail entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyOrderDetail> selectPageList(Page<BuyOrderDetail> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCount(Page<BuyOrderDetail> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BuyOrderDetail> selectPageListUseDyc(Page<BuyOrderDetail> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCountUseDyc(Page<BuyOrderDetail> page) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
