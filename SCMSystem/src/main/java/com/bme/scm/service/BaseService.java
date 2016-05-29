package com.bme.scm.service;

import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016年5月29日
 *
 */


public interface BaseService<T> {
	//添加单个对象
		public int insert (T entity) throws Exception;
		
		//修改单个对象
		public int updateByPk(T entity) throws Exception;
		
		//删除单个对象
		public int delete(T entity) throws Exception;
		
		//查询单个对象
		public T select(T entity);

		//通过关键字分页查询
		public Page<T> selectPage(Page<T> page); 

		//通过多条件分页查询
		public Page<T> selectPageUseDyc(Page<T> page); 
		//通过主键（数组）批量删除数据
		int deleteByPks(String [] pks) throws Exception;
}
