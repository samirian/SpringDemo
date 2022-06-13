package com.springAop.data.springdata;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springAop.schemas.JdbcPerson;
import com.springAop.schemas.JpaPerson;

public interface PersonSpringDataRepository extends JpaRepository<JpaPerson, Integer>{

}
