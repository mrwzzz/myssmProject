package com.mrz.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mrz.o2o.entity.Area;

public class AreaDaoTest extends BaseTest {
@Autowired
private AreaDao areaDao;
@Test
public void test() {
	
	List<Area> a=areaDao.queryArea();
		
		System.out.println(a.get(0));
	
	

}
}