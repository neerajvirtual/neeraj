package com.demo.service;

import java.util.List;

import com.demo.model.Student;
import com.demo.model.UserModel;
import com.demo.model.UserModel;

public interface UserService {

	void saveUser(UserModel user);

	void saveStudent(Student student);

	List<Student> getAllUsers();

}