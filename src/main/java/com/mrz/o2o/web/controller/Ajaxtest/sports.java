package com.mrz.o2o.web.controller.Ajaxtest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrz.o2o.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/shopadmin")
public class sports {
	@RequestMapping(value="/gets",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,String>getSports(){
		Map<String,String> modleMap=new HashMap<String,String>();
		modleMap.put("name","土豪");
		modleMap.put("say","Kimi挖是俺的情故呀");
		
		return modleMap;
	}
	@RequestMapping(value="/Post",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> PostSports(HttpServletRequest request){
		Map<String,Object> modleMap=new HashMap<String,Object>();
		int shopStr=HttpServletRequestUtil.getInt(request, "num");
		System.out.println(shopStr);
		if(shopStr%2==0) {
			modleMap.put("success",false);
			
			
		}else {
			modleMap.put("success",true);
			
		}
	return modleMap;
	}
	
	
}
