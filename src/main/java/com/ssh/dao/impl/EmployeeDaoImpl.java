package com.ssh.dao.impl;


import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.dao.EmployeeDao;
import com.ssh.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao  {

	public Employee findUsernameAndPassword(Employee employee) {
	String hql="from Employee where username =? and password=?";
	List<Employee> list=(List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
	if(list.size()>0)
		return list.get(0);
		return null;
	}

	@Override
	public int findCount() {
		String hql="from Employee";
		List <Employee>list =(List<Employee>) this.getHibernateTemplate().find(hql);
		return list.size();
	}

	@Override
	public List<Employee> finByPage(Integer begin, int pageSize) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List <Employee> list=(List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void add(Employee employee) {
	this.getHibernateTemplate().save(employee);
	}

	@Override
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
		
	}




}
