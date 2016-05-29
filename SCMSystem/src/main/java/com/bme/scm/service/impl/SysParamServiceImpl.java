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
 * @Date     2016��5��29��
 *
 */


@Service(value="sysParamService")
public class SysParamServiceImpl extends BaseServiceImpl<SysParam> implements SysParamService{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Map<String, Object> selectList() {
		List<SysParam> sysParams=sysParamDaoImpl.selectList();
		//ϵͳ����Map,������������ֶε���ز�����Ϣ
		Map<String, Object> sysParamMap =new HashMap<String, Object>();
		
		Map<String, Object> fieldMap=null;
		
		for (SysParam sysParam : sysParams) {
			if("1".equals(sysParam.getSysParamType())){
				//��ȡ��Ҫִ��SQL��������ѯ������
				String sql = sysParam.getSysParamValue();
				System.out.println("========="+sql);
				//ִ�в�ѯ�����ѽ������List�У�Ԫ��Ϊϵͳ�������͵�ʵ��
				List<StoreHouse> otherList= sysParamDaoImpl.selectOtherTable(sql);
				fieldMap = new HashMap<String, Object>();
				//�������������ݴ浽�ֶ�MAP
				for (StoreHouse otherSysParam : otherList) {
					fieldMap.put(otherSysParam.getShId(), otherSysParam.getShName());					
				}
				//���ֶ����Map�����ϵͳ����Map,��ԭϵͳ�������ѯ��sysParam�����sysParamField��Ϊkdy
				sysParamMap.put(sysParam.getSysParamField(), fieldMap);						
				
			}else{
				//�Ӵ��ϵͳ������map��ȡ�ֶε�map
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


