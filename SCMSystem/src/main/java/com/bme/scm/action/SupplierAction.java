package com.bme.scm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bme.scm.entity.Page;
import com.bme.scm.entity.Supplier;
import com.bme.scm.service.SupplierService;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016��5��29��
 *
 */



@Controller
@RequestMapping("/supplier")
public class SupplierAction extends BaseAction{

	@Resource
    private	SupplierService supplierService;
	
	@RequestMapping("/insert")
	@ResponseBody
	public Object insert(Supplier supplier){
		System.out.println("����action.supplier:"+supplier);
		int i=0;
		try {
			i=supplierService.insert(supplier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping("supplierlist")
	public String list(){
		System.out.println("����action.list:");
		return "forward:/WEB-INF/supplier/supplierlist.jsp";
	}
	
	
	//ͨ���ؼ��ַ�ҳ��ѯ
	@RequestMapping("/selectPage")
	@ResponseBody  //����json��ʽ
	public Object selectPage(Page<Supplier> page){
		Page p = supplierService.selectPage(page);
		System.out.println("----page:"+page);
		//page.setParamEntity(supplier);
		//Map<String, Object> pageMap=new HashMap<String, Object>();
		//page=supplierService.selectPage(page);
		//pageMap.put("total", page.getTotalRecord());
		//pageMap.put("rows", page.getList());
		return page.getPageMap();
	}
	
	@RequestMapping("/deleteByPks")
	@ResponseBody
	public Object deleteByPks(String[] pks){
		System.out.println("������deleteByPks.pks:"+pks);
		int i=0;
		try {
			i=supplierService.deleteByPks(pks);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	//�޸Ĺ�Ӧ�̵���Ϣ
	@RequestMapping("/updateByPk")
	@ResponseBody
	public Object updateByPk(Supplier supplier){
		System.out.println("supplier.update:" + supplier);
		int i=0;
		try {
			 i = supplierService.updateByPk(supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}
	
	//ͨ����������ҳ��ѯ
		@RequestMapping("/selectPageUseDyc")
		@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
		public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
			
			page.setParamEntity(supplier);
			System.out.println("----page:"+page);
			Page p = supplierService.selectPageUseDyc(page);
			return p.getPageMap();
		}
	
	
	
}
