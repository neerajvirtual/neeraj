package com.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.demo.model.Address;
import com.demo.model.Student;
import com.demo.model.UserModel;
import com.demo.model.UserModel;

@Repository
public class UserDaoImplement implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.demo.dao.UserDao#saveUser(com.demo.model.UserModel)
	 */
	@Override
	public void saveUser(UserModel user) {
		Session session = entityManager.unwrap(Session.class);
		session.save(user);
	}

	@Override
	public void saveStudent(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.save(student);
	}
}
