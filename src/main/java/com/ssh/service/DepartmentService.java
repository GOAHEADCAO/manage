package com.ssh.service;

import java.util.List;

import com.ssh.domain.Department;
import com.ssh.domain.PageBean;

public interface DepartmentService {


	PageBean<Department> findByPage(Integer currentPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department dep);

	List<Department> getAll();

}
