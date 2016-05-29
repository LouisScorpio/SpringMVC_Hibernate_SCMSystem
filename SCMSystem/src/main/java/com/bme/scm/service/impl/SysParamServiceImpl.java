package com.bme.scm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bme.scm.entity.StoreHouse;
import com.bme.scm.entity.SysParam;
import com.bme.scm.service.SysParamService;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016年5月29日
 *
 */


@Service(value="sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Map<String, Object> selectList() {
		List<SysParam> sysParams=sysParamDaoImpl.selectList();
		//系统参数Map,用来存放所有字段的相关参数信息
		Map<String, Object> sysParamMap =new HashMap<String, Object>();
		
		Map<String, Object> fieldMap=null;
		
		for (SysParam sysParam : sysParams) {
			if("1".equals(sysParam.getSysParamType())){
				//获取需要执行SQL，用来查询其它表
				String sql = sysParam.getSysParamValue();
				System.out.println("========="+sql);
				//执行查询，并把结果存在List中，元素为系统参数类型的实体
				List<StoreHouse> otherList= sysParamDaoImpl.selectOtherTable(sql);
				fieldMap = new HashMap<String, Object>();
				//遍历，并把数据存到字段MAP
				for (StoreHouse otherSysParam : otherList) {
					fieldMap.put(otherSysParam.getShId(), otherSysParam.getShName());					
				}
				//把字段相关Map存放在系统参数Map,用原系统参数表查询的sysParam对象的sysParamField作为kdy
				sysParamMap.put(sysParam.getSysParamField(), fieldMap);						
				
			}else{
				//从存放系统参数的map获取字段的map
				if(sysParamMap.get(sysParam.getSysParamField())==null){
					fieldMap = new HashMap<String, Object>();
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());
					sysParamMap.put(sysParam.getSysParamField(), fieldMap);				
				}else{
					fieldMap = (Map<String, Object>) sysParamMap.get(sysParam.getSysParamField());
					fieldMap.put(sysParam.getSysParamValue(), sysParam.getSysParamText());					
				}
			}
			
		}
		//System.out.println(sys);
		return sysParamMap;
	}


	}


