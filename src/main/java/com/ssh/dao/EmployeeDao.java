package com.ssh.dao;

import java.util.List;

import com.ssh.domain.Employee;

public interface EmployeeDao {

	Employee findUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> finByPage(Integer begin, int pageSize);

	void add(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);


}
