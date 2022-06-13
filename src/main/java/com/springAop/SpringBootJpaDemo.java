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
import com.springAop.data.jpa.PersonJpaRepository;
import com.springAop.schemas.JdbcPerson;
import com.springAop.schemas.JpaPerson;


//@SpringBootApplication
public class SpringBootJpaDemo implements CommandLineRunner{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Person of id = 1001 -> {}", personJpaRepository.findById(1001));
		logger.info("Number of rows deleted -> ");
		personJpaRepository.deleteById(1001);
		logger.info("Person of id = 1001 -> {}", personJpaRepository.findById(1001));
		logger.info("inserting id 1004 -> {}", personJpaRepository.insert(new JpaPerson("n10", "a10", new Date(System.currentTimeMillis()))));
		logger.info("Updateing id 1001 -> {}", personJpaRepository.update(new JpaPerson(1, "n1", "a1", new Date(System.currentTimeMillis()))));
		logger.info("All Persons -> \n{}", personJpaRepository.findAll());
//		logger.info("Number of rows deleted -> {}", JdbcpersonDAO.deleteById(1010));
	}

}
