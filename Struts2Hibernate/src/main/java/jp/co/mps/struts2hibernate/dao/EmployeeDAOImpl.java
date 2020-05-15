package jp.co.mps.struts2hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jp.co.mps.struts2hibernate.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private SessionFactory sf;
	
	public EmployeeDAOImpl(SessionFactory sf){
		this.sf = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List<Employee> result = query.list();
		tx.commit();
		session.close();
		return result;
	}

	@Override
	public void saveOrUpdate(Employee user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Employee user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

}
