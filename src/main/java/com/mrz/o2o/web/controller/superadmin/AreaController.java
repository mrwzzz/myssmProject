package com.mrz.o2o.web.controller.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrz.o2o.entity.Area;
import com.mrz.o2o.service.AreaService;

@Controller
@RequestMapping("/o2oController")
public class AreaController {
@Autowired
private AreaService areaSerivce;
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	@ResponseBody
	private Map<String,Object> listArea(){
		
		
		Map<String,Object>modelMap=new HashMap<String,Object>();
		List<Area>list=new ArrayList<Area>();
		try {
			list=areaSerivce.getArea();
			modelMap.put("rows",list);
			modelMap.put("total",list.size());
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
			
			
		}
		return modelMap;
	}
	
}
