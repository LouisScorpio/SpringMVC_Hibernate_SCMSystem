package com.bme.scm.dao;

import java.util.List;

import com.bme.scm.entity.Page;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */

public interface BaseDao<T> {
	//��ӵ�������
		public int insert(T entity);
		
		//�޸ĵ�������
		public int updateByPk(T entity);
		
		//ɾ���������� 
		public int delete(T entity);
		
		//��ѯ��������
		public T select(T entity);
		
		//ͨ���ؼ��ַ�ҳ��ѯ�����б�
		public List<T> selectPageList(Page<T> page);
		
		//ͨ���ؼ��ַ�ҳ��ѯ�������ܼ�¼��
		public Integer selectPageCount(Page<T> page);
		
		//����ɾ��
		public int deleteByPks(String[] pks);

		//ͨ���ؼ��ַ�ҳ��ѯ�����б�  ������
		public List<T> selectPageListUseDyc(Page<T> page);
				
	  //ͨ���ؼ��ַ�ҳ��ѯ�������ܼ�¼��   ������
		public Integer selectPageCountUseDyc(Page<T> page);
}
