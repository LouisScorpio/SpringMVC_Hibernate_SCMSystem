package com.bme.scm.dao;

import java.util.List;

import com.bme.scm.entity.StoreHouse;
import com.bme.scm.entity.SysParam;

/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */

public interface SysParamDao extends BaseDao<SysParam>{

	public List<SysParam> selectList();
	public List<StoreHouse> selectOtherTable(String sql);

}
