package com.bme.scm.service;

import java.util.Map;

import com.bme.scm.entity.SysParam;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */


public interface SysParamService extends BaseService<SysParam> {
    public Map<String,Object> selectList();
	
}
