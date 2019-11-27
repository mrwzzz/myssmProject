package com.mrz.o2o.util;

public class PathUtil {
//得到系统的分割符
	private static String seperator=System.getProperty("file.separator");
	//返回项目图片的根路径
	public static String getImgBasePath() {
	String os=System.getProperty("os.name");	
		String basePath="";
		//判断操作系统
		if(os.toLowerCase().startsWith("win")){
			basePath="B:/projectdedv/image/";
		}else {
			
			
			
			basePath="/home/mr.z/image/";
			
			
			
			
			
			
		}
		basePath=basePath.replace("/", seperator);
		
		return basePath;
		
		
	}
//根据需求返回图片子路径
	public static String getShopImagePath(long shopId) {
		String  imagePath="/upload/item/shop"+shopId+"/";
		return imagePath.replace("/", seperator);
		
		
	
		
	}
	
	
	
}
