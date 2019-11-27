package com.mrz.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrz.o2o.dao.AreaDao;
import com.mrz.o2o.entity.Area;
import com.mrz.o2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao areadao;

	public List<Area> getArea() {
		// TODO Auto-generated method stub
		return areadao.queryArea();
	}

}
