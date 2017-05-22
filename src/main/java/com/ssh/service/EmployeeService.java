package com.ssh.service;

import com.ssh.domain.Employee;
import com.ssh.domain.PageBean;

//
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currentPage);

	void add(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);


}
