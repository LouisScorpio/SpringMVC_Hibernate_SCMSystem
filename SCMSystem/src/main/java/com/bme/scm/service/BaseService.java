package com.bme.scm.service;

import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */


public interface BaseService<T> {
	//��ӵ�������
		public int insert (T entity) throws Exception;
		
		//�޸ĵ�������
		public int updateByPk(T entity) throws Exception;
		
		//ɾ����������
		public int delete(T entity) throws Exception;
		
		//��ѯ��������
		public T select(T entity);

		//ͨ���ؼ��ַ�ҳ��ѯ
		public Page<T> selectPage(Page<T> page); 

		//ͨ����������ҳ��ѯ
		public Page<T> selectPageUseDyc(Page<T> page); 
		//ͨ�����������飩����ɾ������
		int deleteByPks(String [] pks) throws Exception;
}
