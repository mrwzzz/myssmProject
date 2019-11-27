package com.mrz.o2o.web.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin",method= {RequestMethod.GET})
//访问web-inf内的html
public class ShopAdminController {
@RequestMapping(value="/shopoperation")
public String shopOperation() {
	return "shop/shopoperation";
	
	
}@RequestMapping(value="/shoplist")
public String shopList() {
	
	return "shop/shoplist";
	
}
@RequestMapping(value="/shopmangement")
public String shopmangemen() {
	
	return "shop/shopmangement";

}
@RequestMapping(value="/commodityUnit")
public String commodityUnit() {
	return "shop/commodityUnit";
	
	
	
} 
@RequestMapping(value="/productmanage")
public String productmanage() {
	
	return "NewFile";
	
	
	
	
}

@RequestMapping(value="/productoperation")
public String productoperation() {
	
	return "Product/productedit";
	
	
	
	
}

}
