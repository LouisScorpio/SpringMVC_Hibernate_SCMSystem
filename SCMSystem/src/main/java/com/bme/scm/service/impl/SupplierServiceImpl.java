package com.bme.scm.service.impl;



import org.springframework.stereotype.Service;
import com.bme.scm.entity.Supplier;
import com.bme.scm.service.SupplierService;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */


@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {
	/*
    @Resource
	private SupplierDaoImpl supplierDaoImpl;

	@Override
	@Transactional
	public int insert(Supplier supplier) throws Exception {
		// TODO Auto-generated method stub
		return supplierDaoImpl.insertSupplier(supplier);
	}

	@Override
	@Transactional
	public int updateByPk(Supplier entity) throws Exception {
		// TODO Auto-generated method stub
		return supplierDaoImpl.updateByPk(entity);
	}

	@Override
	public int delete(Supplier entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Supplier select(Supplier entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Page<Supplier> selectPage(Page<Supplier> page) {
		page.setList(supplierDaoImpl.selectPageList(page));
		page.setTotalRecord(supplierDaoImpl.selectPageCount(page));
		return page;
	}

	@Override
	@Transactional
	public int deleteByPks(String[] pks) throws Exception {
		// TODO Auto-generated method stub
		return supplierDaoImpl.deleteByPks(pks);
	}

	@Override
	public Page<Supplier> selectPageUseDyc(Page<Supplier> page) {
		// TODO Auto-generated method stub
		return null;
	}

*/

}
