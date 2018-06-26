package com.example.demo.service;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Person;
@Repository
public class PersonServiceImpl implements PersonServiceInterface {
	@Autowired
    private Dao dao;
	
	@Override
	public <T> T getPersonByPropertis(Class<T> calssof,String pro) {
		// TODO Auto-generated method stub
		T result = dao.fetch(calssof,pro);
		return result;
	}


	@Override
	public void insertObj(Object p) {
		// TODO Auto-generated method stub
		dao.insert(p);
	}


	@Override
	public void createTable(Class<?> table) {
		// TODO Auto-generated method stub
		dao.create(table,false);
	}

}
