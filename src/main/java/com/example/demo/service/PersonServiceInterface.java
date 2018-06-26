package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Person;

public interface PersonServiceInterface {

	public void createTable(Class<?> tab); 
	
	public void insertObj(Object p);
	
	public <T> T getPersonByPropertis(Class<T> calssof,String pro);
}
