package com.springAop.data.jpa;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springAop.schemas.JdbcPerson;
import com.springAop.schemas.JpaPerson;

@Repository
@Transactional
public class PersonJpaRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<JpaPerson> findAll(){
		TypedQuery<JpaPerson> namedQuery = entityManager.createNamedQuery("find_all_persons", JpaPerson.class);
		return namedQuery.getResultList();
	}
	
	public JpaPerson findById(int id){
		return entityManager.find(JpaPerson.class, id);
	}

	public void deleteById(int id){
		JpaPerson jpaPerson = findById(id);
		entityManager.remove(jpaPerson);
	}
	
	public JpaPerson insert(JpaPerson person){
		return entityManager.merge(person);
	}
	
	public JpaPerson update(JpaPerson person){
		return entityManager.merge(person);
	}
}
