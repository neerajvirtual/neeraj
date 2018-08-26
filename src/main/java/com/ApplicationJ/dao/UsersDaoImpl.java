package com.ApplicationJ.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.ApplicationJ.modelBO.UsersBO;

@Repository
public class UsersDaoImpl implements UsersDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UsersBO> getActiveUsers() {
		CriteriaBuilder queryBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UsersBO> criteriaQuery = queryBuilder.createQuery(UsersBO.class);
		Root<UsersBO> entityRoot = criteriaQuery.from(UsersBO.class);
		List<UsersBO> userList = entityManager.createQuery(criteriaQuery).getResultList();
		return userList;
	}
	
	@Override
	public UsersBO addUser(UsersBO userbo) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(userbo);
		entityManager.flush();
		entityManager.clear();
		return userbo; 
	}

	@Override
	public UsersBO getUserById(int id) {
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		List<UsersBO> list = (List<UsersBO>) session
				.createQuery("FROM UsersBO as a where a.id=" + id + "").list();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

}
