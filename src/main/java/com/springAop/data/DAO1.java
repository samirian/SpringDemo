package com.springAop.data;

import org.springframework.stereotype.Repository;

import com.springAop.aspect.TrackTime;

@Repository
public class DAO1 {
	@TrackTime
	public String retrieveName() {
		return "DAO1";
	}
}
