package com.ssh.dao;

import java.util.List;

import com.ssh.domain.Department;

public interface DepartmentDao {

	Integer findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

    Department findById(Integer did);

	void update(Department department);

	void delete(Department dep);

	List<Department> getAll();

}
