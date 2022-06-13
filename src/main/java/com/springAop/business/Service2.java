package com.springAop.business;

import org.springframework.stereotype.Service;

import com.springAop.data.DAO2;

@Service
public class Service2 {
	private DAO2 dao2;

	public Service2(DAO2 dao2) {
		super();
		this.dao2 = dao2;
	}
	
	public String retrieveSomeShit() {
		return dao2.retriveSomeShit();
	}
}
