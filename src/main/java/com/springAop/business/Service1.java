package com.springAop.business;

import org.springframework.stereotype.Service;

import com.springAop.data.DAO1;

@Service
public class Service1 {

	private DAO1 dao1;

	public Service1(DAO1 dao1) {
		super();
		this.dao1 = dao1;
	}
	
	public String doSomeBusiness() {
		return dao1.retrieveName();
	}
}
