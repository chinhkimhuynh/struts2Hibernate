package jp.co.mps.struts2hibernate.dao;

import java.util.List;

import jp.co.mps.struts2hibernate.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
	
	void saveOrUpdate(Employee user);
	
	void delete(Employee user);
	
}
