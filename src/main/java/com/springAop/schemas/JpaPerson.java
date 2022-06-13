package com.springAop.schemas;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity // indicates that this class is mapped to a table and to be managed by the JPA.
@Table(name="person") // optional if the class has the same name of the table
@NamedQuery(name="find_all_persons", query = "select p from JpaPerson p")
public class JpaPerson {
	@Id // indicates that this field is a primary key.
	@GeneratedValue(strategy = GenerationType.AUTO) // inicates that Hibernate will generate the ids automatically.
	@Column(name = "id") // optional if the field has the same name as the table column.
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "location")
	private String location;
	@Column(name = "birth_date")
	private Date birthDate;
	
	public JpaPerson() {
		
	}
	
	public JpaPerson(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	public JpaPerson(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]\n";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
