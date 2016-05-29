package com.bme.scm.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author   LouisScorpio
 * @Company  ZJU.BME
 * @Date     2016Äê5ÔÂ29ÈÕ
 *
 */


@Controller
@RequestMapping("/base")
public class BaseAction {

	@Resource
	ServletContext application;
	
	@RequestMapping("/goURL/{folder}/{file}")
	public String goURL(@PathVariable String folder,@PathVariable String file){
	  System.out.println("goURL.folder|file==="+folder+"/"+file);
	  return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
	}
}
