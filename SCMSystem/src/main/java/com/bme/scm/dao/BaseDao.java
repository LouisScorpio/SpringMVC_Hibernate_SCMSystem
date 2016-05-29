package com.bme.scm.dao;

import java.util.List;

import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016年5月29日
 *
 */

public interface BaseDao<T> {
	//添加单个对象
		public int insert(T entity);
		
		//修改单个对象
		public int updateByPk(T entity);
		
		//删除单个对象 
		public int delete(T entity);
		
		//查询单个对象
		public T select(T entity);
		
		//通过关键字分页查询数据列表
		public List<T> selectPageList(Page<T> page);
		
		//通过关键字分页查询，返回总记录数
		public Integer selectPageCount(Page<T> page);
		
		//批量删除
		public int deleteByPks(String[] pks);

		//通过关键字分页查询数据列表  多条件
		public List<T> selectPageListUseDyc(Page<T> page);
				
	  //通过关键字分页查询，返回总记录数   多条件
		public Integer selectPageCountUseDyc(Page<T> page);
}
