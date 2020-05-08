package com.journaldev.struts2hibernate.dao;

import java.util.List;

import com.journaldev.struts2hibernate.model.User;

public interface UserDAO {

	User getUserByCredentials(String userId, String password);
	
	List<User> findAll();
	
	void saveOrUpdate(User user);
	
	void delete(User user);
	
}
