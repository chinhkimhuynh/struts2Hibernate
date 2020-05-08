package com.journaldev.struts2hibernate.form;

import java.util.ArrayList;
import java.util.List;

import com.journaldev.struts2hibernate.model.User;

public class UserActionForm {
	
	private User user = new User();
	
	private List<User> users = new ArrayList<User>();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
