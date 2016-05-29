package com.bme.scm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bme.scm.dao.BuyOrderDao;
import com.bme.scm.entity.BuyOrder;
import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */

@Repository
public class BuyOrderDaoImpl implements BuyOrderDao{

	@Resource
	private SessionFactory sessionFactory;
	@Override
	public int insert(BuyOrder entity) {
		
		
		return (int)sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public int updateByPk(BuyOrder entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BuyOrder entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BuyOrder select(BuyOrder entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuyOrder> selectPageList(Page<BuyOrder> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCount(Page<BuyOrder> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BuyOrder> selectPageListUseDyc(Page<BuyOrder> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCountUseDyc(Page<BuyOrder> page) {
		// TODO Auto-generated method stub
		return null;
	}

}
