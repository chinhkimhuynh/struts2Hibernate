package jp.co.mps.struts2hibernate.form;

import java.util.ArrayList;
import java.util.List;

import jp.co.mps.struts2hibernate.entity.Employee;

public class EmployeeActionForm {
	
	private Employee employee = new Employee();
	
	private List<Employee> employees = new ArrayList<Employee>();

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
