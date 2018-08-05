package com.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.demo.modelBO.UsersBO;

@Repository
public class UsersDaoImpl implements UsersDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UsersBO> getActiveUsers() {
		List<UsersBO> users=null;
		Session session = entityManager.unwrap(Session.class);
		try {
		//Criteria createCriteria = session.getSessionFactory().getCurrentSession().createCriteria(UsersBO.class);
		users = session.getSessionFactory().openSession().createCriteria(UsersBO.class).list();
		}catch(Exception e) {
			System.out.println("error message got "+e.getMessage());
		}
		return users;
	}
	
	@Override
	public UsersBO addUser(UsersBO userbo) {
		Session session = entityManager.unwrap(Session.class);
		session.save(userbo);
		return userbo; 
	}

}
