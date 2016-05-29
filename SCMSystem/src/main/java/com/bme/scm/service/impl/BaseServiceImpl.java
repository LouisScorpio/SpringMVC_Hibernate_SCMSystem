package com.bme.scm.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.bme.scm.dao.BaseDao;
import com.bme.scm.dao.impl.AccountDaoImpl;
import com.bme.scm.dao.impl.AccountRecordsDaoImpl;
import com.bme.scm.dao.impl.BuyOrderDaoImpl;
import com.bme.scm.dao.impl.BuyOrderDetailDaoImpl;
import com.bme.scm.dao.impl.GoodsDaoImpl;
import com.bme.scm.dao.impl.SupplierDaoImpl;
import com.bme.scm.dao.impl.SysParamDaoImpl;
import com.bme.scm.entity.Page;
import com.bme.scm.service.BaseService;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */


public class BaseServiceImpl<T> implements BaseService<T> {

	@Resource
	protected SupplierDaoImpl supplierDaoImpl;
	
	@Resource
	protected AccountDaoImpl accountDaoImpl;
	
	@Resource
	protected GoodsDaoImpl goodsDaoImpl;
	
	@Resource
	protected BuyOrderDaoImpl buyOrderDaoImpl;
	
	@Resource
	protected BuyOrderDetailDaoImpl buyOrderDetailDaoImpl;
	
	@Resource
	protected AccountRecordsDaoImpl accountRecordsDaoImpl;
	
	@Resource
	protected SysParamDaoImpl sysParamDaoImpl;
	
	protected BaseDao<T> baseDao;
	
	@PostConstruct//�ڹ��췽���󣬳�ʼ��ǰִ��
	private void initBaseDao() throws Exception{
		//��������߼�����Ҫ���з��������������ʹ�ù淶
		//this�ؼ���ָ����������ָ���ǵ��ô˷�����ʵ���ࣨ���ࣩ
		System.out.println("======this:"+this);
		System.out.println("======���������Ϣ��"+this.getClass().getSuperclass());
		System.out.println("======����ͷ��͵���Ϣ��"+this.getClass().getGenericSuperclass());
	    ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
	    //��ȡ��һ��������class
	    Class clazz = (Class) type.getActualTypeArguments()[0];
	    System.out.println("======class:"+clazz);
	    //ת��Ϊ������,��ص�dao�����������  entityDaoImpl
	    String localField=clazz.getSimpleName().substring(0, 1).toLowerCase()+clazz.getSimpleName().substring(1)+"DaoImpl";
	    System.out.println("=======localField:"+localField);
	Field field = this.getClass().getSuperclass().getDeclaredField(localField);
	System.out.println("=======field:"+field);
	System.out.println("=======field��Ӧ�Ķ���:"+field.get(this));//��field��this�е�ֵ��ʲô
	Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");
	System.out.println("=======baseField:"+baseField);
	System.out.println("=======baseField��Ӧ�Ķ���:"+baseField.get(this));	
   //field.get(this)��ȡ��ǰthis��field�ֶε�ֵ�����磺Supplier�����У�baseDao��ָ��Ķ���
	//Ϊ��������SupplierDaoImpl����
	//�൱�ڳ�ʼ��baseDao  ��supplierDaoImpl����accountDaoImpl��ֵ����baseDao
	baseField.set(this, field.get(this));
	System.out.println("========baseField��Ӧ�Ķ���:"+baseDao);
	}
	@Override
	@Transactional
	public int insert(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.insert(entity);
	}

	@Override
	@Transactional
	public int updateByPk(T entity) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.updateByPk(entity);
	}

	@Override
	public int delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T select(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Page<T> selectPage(Page<T> page) {
		// TODO Auto-generated method stub
		page.setList(baseDao.selectPageList(page));
		page.setTotalRecord(baseDao.selectPageCount(page));
		return page;
		
	}

	@Override
	@Transactional
	public int deleteByPks(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return supplierDaoImpl.deleteByPks(pks);
	}
	@Override
	@Transactional
	public Page<T> selectPageUseDyc(Page<T> page) {
		page.setList(baseDao.selectPageListUseDyc(page));
		page.setTotalRecord(baseDao.selectPageCountUseDyc(page));
		return page;
	}

}
