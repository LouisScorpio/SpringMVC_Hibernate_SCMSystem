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
 * @Date     2016年5月29日
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
		System.out.println("——action.supplier:"+supplier);
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
		System.out.println("——action.list:");
		return "forward:/WEB-INF/supplier/supplierlist.jsp";
	}
	
	
	//通过关键字分页查询
	@RequestMapping("/selectPage")
	@ResponseBody  //返回json格式
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
		System.out.println("———deleteByPks.pks:"+pks);
		int i=0;
		try {
			i=supplierService.deleteByPks(pks);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	//修改供应商的信息
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
	
	//通过多条件分页查询
		@RequestMapping("/selectPageUseDyc")
		@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
		public Object selectPageUseDyc(Page<Supplier> page,Supplier supplier){
			
			page.setParamEntity(supplier);
			System.out.println("----page:"+page);
			Page p = supplierService.selectPageUseDyc(page);
			return p.getPageMap();
		}
	
	
	
}
