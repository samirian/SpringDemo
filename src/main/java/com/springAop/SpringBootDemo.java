package com.springAop;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springAop.business.Service1;
import com.springAop.business.Service2;
import com.springAop.data.jdbc.PersonDAO;
import com.springAop.schemas.JdbcPerson;


//@SpringBootApplication
public class SpringBootDemo implements CommandLineRunner{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Service1 service1;
	
	@Autowired
	Service2 service2;
	
	@Autowired
	PersonDAO JdbcpersonDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info(service1.doSomeBusiness());
//		logger.info(service2.retrieveSomeShit());
		logger.info("Person of id = 1001 -> {}", JdbcpersonDAO.findById(1001));
		logger.info("Number of rows deleted -> {}", JdbcpersonDAO.deleteById(1010));
		logger.info("inserting id 1004 -> {}", JdbcpersonDAO.insert(new JdbcPerson(1010, "n10", "a10", new Date(System.currentTimeMillis()))));
		logger.info("Updateing id 1001 -> {}", JdbcpersonDAO.update(new JdbcPerson(
																		1001, "n1", "a1", new Date(System.currentTimeMillis())
																	)));
		logger.info("All Persons -> \n{}", JdbcpersonDAO.findAll());
		logger.info("Number of rows deleted -> {}", JdbcpersonDAO.deleteById(1010));
	}

}
