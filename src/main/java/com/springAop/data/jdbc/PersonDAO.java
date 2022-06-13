package com.springAop.data.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springAop.schemas.JdbcPerson;

/*
 * default rowMapper can be BeanPropertyRowMapper<Person>(Person.class) 
 * if we have the fields the same name as the table columns.
 */

@Repository
public class PersonDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PersonRowMappper personRowMappper;
	
	public List<JdbcPerson> findAll(){
		return jdbcTemplate.query("SELECT * FROM person", personRowMappper);
	}
	
	public JdbcPerson findById(int id){
		return jdbcTemplate.queryForObject(
				"SELECT * FROM person WHERE id=?",
				personRowMappper,
				new Object[] {id}
			);
	}

	public int deleteById(int id){
		return jdbcTemplate.update(
				"DELETE FROM person WHERE id=?",
				new Object[] {id}
			);
	}
	
	public int insert(JdbcPerson jdbcPerson){
		return jdbcTemplate.update(
				"INSERT into person (id, name, location, birth_date) values(?,?,?,?)",
				new Object[] {
						jdbcPerson.getId(),
						jdbcPerson.getName(),
						jdbcPerson.getLocation(),
						new Timestamp(jdbcPerson.getBirthDate().getTime())
				}
			);
	}
	
	public int update(JdbcPerson jdbcPerson){
		return jdbcTemplate.update(
				"update person " +
				"set name=?, location=?, birth_date=?" +
				"where id=?",
				new Object[] {
						jdbcPerson.getName(),
						jdbcPerson.getLocation(),
						new Timestamp(jdbcPerson.getBirthDate().getTime()),
						jdbcPerson.getId()
				}
			);
	}
}
