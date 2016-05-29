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
 * @Date     2016年5月29日
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
	
	@PostConstruct//在构造方法后，初始化前执行
	private void initBaseDao() throws Exception{
		//完成以下逻辑，需要对研发本身进行命名与使用规范
		//this关键字指对象本身，这里指的是调用此方法的实现类（子类）
		System.out.println("======this:"+this);
		System.out.println("======父类基本信息："+this.getClass().getSuperclass());
		System.out.println("======父类和泛型的信息："+this.getClass().getGenericSuperclass());
	    ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
	    //获取第一个参数的class
	    Class clazz = (Class) type.getActualTypeArguments()[0];
	    System.out.println("======class:"+clazz);
	    //转化为属性名,相关的dao子类的引用名  entityDaoImpl
	    String localField=clazz.getSimpleName().substring(0, 1).toLowerCase()+clazz.getSimpleName().substring(1)+"DaoImpl";
	    System.out.println("=======localField:"+localField);
	Field field = this.getClass().getSuperclass().getDeclaredField(localField);
	System.out.println("=======field:"+field);
	System.out.println("=======field对应的对象:"+field.get(this));//该field在this中的值是什么
	Field baseField=this.getClass().getSuperclass().getDeclaredField("baseDao");
	System.out.println("=======baseField:"+baseField);
	System.out.println("=======baseField对应的对象:"+baseField.get(this));	
   //field.get(this)获取当前this的field字段的值。例如：Supplier对象中，baseDao所指向的对象
	//为其子类型SupplierDaoImpl对象
	//相当于初始化baseDao  把supplierDaoImpl或者accountDaoImpl的值赋给baseDao
	baseField.set(this, field.get(this));
	System.out.println("========baseField对应的对象:"+baseDao);
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
