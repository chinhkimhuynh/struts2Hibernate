package com.journaldev.struts2hibernate.action;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.hibernate.SessionFactory;

import com.journaldev.struts2hibernate.dao.UserDAO;
import com.journaldev.struts2hibernate.dao.UserDAOImpl;
import com.journaldev.struts2hibernate.form.UserActionForm;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements Action, ModelDriven<UserActionForm>, ServletContextAware {
	
	private UserActionForm userActionForm = new UserActionForm();
	
	private ServletContext ctx;

	@Override
	public void setServletContext(ServletContext sc) {
		this.ctx = sc;
	}
	
	@Override
	public UserActionForm getModel() {
		return userActionForm;
	}

	@Override
	public String execute() throws Exception {
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		UserDAO userDAO = new UserDAOImpl(sf);
		this.userActionForm.setUsers(userDAO.findAll());
		return SUCCESS;
	}
	
	public String saveOrupdate() {
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		UserDAO userDAO = new UserDAOImpl(sf);
		userDAO.saveOrUpdate(userActionForm.getUser());
		return SUCCESS;
	}
	
	public String delete() {
		SessionFactory sf = (SessionFactory) ctx.getAttribute("SessionFactory");
		UserDAO userDAO = new UserDAOImpl(sf);
		userDAO.delete(userActionForm.getUser());
		return SUCCESS;
	}

	public UserActionForm getUserActionForm() {
		return userActionForm;
	}

	public void setUserActionForm(UserActionForm userActionForm) {
		this.userActionForm = userActionForm;
	}

}
