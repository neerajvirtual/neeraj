package com.demo.dao;

import java.util.List;

import com.demo.model.Student;
import com.demo.model.UserModel;
import com.demo.model.UserModel;

public interface UserDao {

	void saveUser(UserModel user);

	void saveStudent(Student student);

	List<Student> getAllUsers();

}