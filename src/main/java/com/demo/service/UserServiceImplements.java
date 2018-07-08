package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.model.Student;
import com.demo.model.UserModel;
import com.demo.model.UserModel;

@Service
@Transactional
public class UserServiceImplements implements UserService {

	@Autowired
	UserDao userdao;
	
	/* (non-Javadoc)
	 * @see com.demo.service.UserService#saveUser(com.demo.model.UserModel)
	 */
	@Override
	public void saveUser(UserModel user) {
		userdao.saveUser(user);
	}

	@Override
	public void saveStudent(Student student) {
		userdao.saveStudent(student);
	}
	
	@Override
	public List<Student> getAllUsers() {
		return userdao.getAllUsers();
	}
	
}
