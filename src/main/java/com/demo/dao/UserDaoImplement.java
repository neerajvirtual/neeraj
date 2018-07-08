package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public List<Student> getAllUsers() {		
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = queryBuilder.createQuery(Student.class);
		Root<Student> entityRoot = criteriaQuery.from(Student.class);
		criteriaQuery.select(entityRoot);
		List<Student> list = entityManager.createQuery(criteriaQuery).getResultList();
		return list;
	}
}
