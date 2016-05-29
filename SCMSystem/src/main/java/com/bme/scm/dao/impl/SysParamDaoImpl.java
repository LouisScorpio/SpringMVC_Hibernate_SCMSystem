package com.bme.scm.dao.impl;

import java.util.List;







import javax.annotation.Resource;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.bme.scm.dao.SysParamDao;
import com.bme.scm.entity.Page;
import com.bme.scm.entity.StoreHouse;
import com.bme.scm.entity.SysParam;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */

@Repository
public class SysParamDaoImpl implements SysParamDao{

	@Resource
	private SessionFactory sessionFactory;
	@Override
	public int insert(SysParam entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(SysParam entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(SysParam entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysParam select(SysParam entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysParam> selectPageList(Page<SysParam> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCount(Page<SysParam> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SysParam> selectPageListUseDyc(Page<SysParam> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCountUseDyc(Page<SysParam> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SysParam> selectList() {
	return 	sessionFactory.getCurrentSession().createCriteria(SysParam.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreHouse> selectOtherTable(String sql) {
		
		
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(StoreHouse.class);
		
		return query.list();
	
		
	}

}
