package com.springAop.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springAop.schemas.JdbcPerson;

@Component
public class PersonRowMappper implements RowMapper<JdbcPerson>{

	@Override
	public JdbcPerson mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		JdbcPerson jdbcPerson = new JdbcPerson();
		jdbcPerson.setId(resultSet.getInt("id"));
		jdbcPerson.setName(resultSet.getString("name"));
		jdbcPerson.setLocation(resultSet.getString("location"));
		jdbcPerson.setBirthDate(resultSet.getDate("birth_date"));
		return jdbcPerson;
	}

}
