package com.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.EmployeeDao;
import com.ssh.domain.Employee;
import com.ssh.domain.PageBean;
import com.ssh.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
private EmployeeDao employeeDao;

public void setEmployeeDao(EmployeeDao employeeDao) {
	this.employeeDao = employeeDao;
}

@Override
public Employee login(Employee employee) {
	Employee employee1=employeeDao.findUsernameAndPassword(employee);
	return employee1;
}

@Override
public PageBean<Employee> findByPage(Integer currentPage) {
	PageBean <Employee>page=new PageBean<Employee>();
	page.setCurrentPage(currentPage);
	int pageSize=5;
	page.setPageSize(pageSize);
	int totalCount= employeeDao.findCount();
	page.setTotalCount(totalCount);
	int totalPage=(int) Math.ceil((double)totalCount/pageSize);
	page.setTotalPage(totalPage);
	Integer  begin=(currentPage-1)*pageSize;
	List<Employee>list=employeeDao.finByPage(begin,pageSize);
	page.setList(list);
	return page;
}

@Override
public void add(Employee employee) {
	employeeDao.add(employee);
}

@Override
public Employee findById(Integer eid) {
	return employeeDao.findById(eid);
}

@Override
public void update(Employee employee) {
	employeeDao.update(employee);
	
}

@Override
public void delete(Employee employee) {
employeeDao.delete(employee);
	
}

}
