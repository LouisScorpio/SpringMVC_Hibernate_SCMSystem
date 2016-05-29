package com.bme.scm.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bme.scm.dao.GoodsDao;
import com.bme.scm.entity.Goods;
import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */

@Repository
public class GoodsDaoImpl implements GoodsDao{
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public int insert(Goods entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPk(Goods entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Goods entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goods select(Goods entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> selectPageList(Page<Goods> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectPageCount(Page<Goods> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByPks(String[] pks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goods> selectPageListUseDyc(Page<Goods> page) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Goods.class);
		if(page.getParamEntity().getGoodsName()!=null){
			criteria.add(Restrictions.like("goodsName", page.getParamEntity().getGoodsName()));
			}
			
		criteria.setFirstResult(page.getStart());
		criteria.setMaxResults(page.getRows());
		List<Goods> goods = criteria.list();
		return goods;
	}

	@Override
	public Integer selectPageCountUseDyc(Page<Goods> page) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Goods.class);
		if(page.getParamEntity().getGoodsName()!=null){
		criteria.add(Restrictions.like("goodsName", page.getParamEntity().getGoodsName()));
		}
		criteria.setProjection(Projections.rowCount());
		Integer l = ((Long)criteria.uniqueResult()).intValue();
		return l;
	}

	
}
