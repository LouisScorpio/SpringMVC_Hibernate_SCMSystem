package com.bme.scm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bme.scm.dao.SupplierDao;
import com.bme.scm.entity.Page;
import com.bme.scm.entity.Supplier;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016年5月29日
 *
 */

@Repository
public class SupplierDaoImpl implements SupplierDao{

	@Resource
	private SessionFactory sessionFactory;
	
	

	@Override
	public int updateByPk(Supplier entity) {
		int i=0;
		try{
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
		i=1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return i;
	}

	@Override
	public int delete(Supplier entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Supplier select(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(supplier);
		    return 1;
		} catch (Exception e) {
			throw e;
		
		}
		
		
	}

	//通过关键字分页查询，返回数据集
	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> selectPageList(Page<Supplier> page) {
	Session session = sessionFactory.getCurrentSession();
	Criteria criteria = session.createCriteria(Supplier.class);
	if(page.getKeyWord()!=null){
	criteria.add(Restrictions.like("supName", page.getKeyWord()));
	}
	criteria.setFirstResult(page.getStart());
	criteria.setMaxResults(page.getRows());
	List<Supplier> suppliers = criteria.list();
	return suppliers;
	
	
		
	}

	// 通过关键字分页查询，返回总记录数
	@Override
	public Integer selectPageCount(Page<Supplier> page) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Supplier.class);
		if(page.getKeyWord()!=null){
		criteria.add(Restrictions.like("supName", page.getKeyWord()));
		}
		criteria.setProjection(Projections.rowCount());
		Integer l = ((Long)criteria.uniqueResult()).intValue();
		return l;
		
	}

	@Override
	public int deleteByPks(String[] pks) {
		int i=0;
		Session session = sessionFactory.getCurrentSession();
		try{
		for(String pk:pks){
			Supplier supplier = (Supplier) session.get(Supplier.class, Integer.parseInt(pk));
			session.delete(supplier);	
	     }
		i=1;
		}catch(Exception ex){
			ex.printStackTrace();
			i=0;
		}
       return i;
	
	}

	//多条件分页查询
	@Override
	public List<Supplier> selectPageListUseDyc(Page<Supplier> page) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Supplier.class);
		if(page.getParamEntity().getSupName()!=null){
			criteria.add(Restrictions.like("supName", page.getParamEntity().getSupName()));
			}
			if(page.getParamEntity().getSupAddress()!=null){
				criteria.add(Restrictions.like("supAddress", page.getParamEntity().getSupAddress()));
			}
		criteria.setFirstResult(page.getStart());
		criteria.setMaxResults(page.getRows());
		List<Supplier> suppliers = criteria.list();
		return suppliers;
	}

	//多条件 分页查询，返回记录总数
	@Override
	public Integer selectPageCountUseDyc(Page<Supplier> page) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Supplier.class);
		if(page.getParamEntity().getSupName()!=null){
		criteria.add(Restrictions.like("supName", page.getParamEntity().getSupName()));
		}
		if(page.getParamEntity().getSupAddress()!=null){
			criteria.add(Restrictions.like("supAddress", page.getParamEntity().getSupAddress()));
			}
		criteria.setProjection(Projections.rowCount());
		Integer l = ((Long)criteria.uniqueResult()).intValue();
		return l;
	}
	

}
