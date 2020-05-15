/**
 * アクションクラス
 * Controller, route, Servletクラスのらしい。
 */
package jp.co.mps.struts2hibernate.action;

import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import jp.co.mps.struts2hibernate.dao.EmployeeDAO;
import jp.co.mps.struts2hibernate.dao.EmployeeDAOImpl;
import jp.co.mps.struts2hibernate.form.EmployeeActionForm;
import jp.co.mps.struts2hibernate.utils.HibernateUtil;

public class EmployeeAction implements Action, ModelDriven<EmployeeActionForm> {
	
	/**
	 * Submit, クライアントへ戻るObject
	 */
	private EmployeeActionForm employeeActionForm = new EmployeeActionForm();
	
	@Override
	public EmployeeActionForm getModel() {
		return employeeActionForm;
	}

	/**
	 * ホームページを表示するメソッド
	 */
	@Override
	public String execute() throws Exception {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		EmployeeDAO userDAO = new EmployeeDAOImpl(sf);
		this.employeeActionForm.setEmployees(userDAO.findAll());
		return SUCCESS;
	}
	
	/**
	 * 登録、変更するメソッド
	 * @return
	 */
	public String saveOrupdate() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		EmployeeDAO userDAO = new EmployeeDAOImpl(sf);
		userDAO.saveOrUpdate(employeeActionForm.getEmployee());
		return SUCCESS;
	}
	
	/**
	 * 削除するメソッド
	 * @return
	 */
	public String delete() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		EmployeeDAO userDAO = new EmployeeDAOImpl(sf);
		userDAO.delete(employeeActionForm.getEmployee());
		return SUCCESS;
	}

	public EmployeeActionForm getEmployeeActionForm() {
		return employeeActionForm;
	}

	public void setEmployeeActionForm(EmployeeActionForm employeeActionForm) {
		this.employeeActionForm = employeeActionForm;
	}

}
