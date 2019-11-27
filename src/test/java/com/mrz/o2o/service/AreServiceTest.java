package com.mrz.o2o.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrz.o2o.dao.BaseTest;
import com.mrz.o2o.entity.Area;

public class AreServiceTest extends BaseTest {
@Autowired
	private AreaService as;
	@Test
public void test() {
	List<Area> skr= as.getArea();
		
		
		for (Area area : skr) {
			System.out.println(area.getAreaId());
		}
		
	}
	
	
}
