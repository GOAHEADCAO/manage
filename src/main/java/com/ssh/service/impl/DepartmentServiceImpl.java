package com.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.DepartmentDao;
import com.ssh.domain.Department;
import com.ssh.domain.PageBean;
import com.ssh.service.DepartmentService;
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
	this.departmentDao = departmentDao;
}

	@Override
	public PageBean<Department> findByPage(Integer currentPage) {
		PageBean <Department> page=new PageBean<Department>();
		page.setCurrentPage(currentPage);
		int pageSize=3;
		page.setPageSize(pageSize);
		int  totalCount=departmentDao.findCount();
		page.setTotalCount(totalCount);
		double totalPage=Math.ceil((double)totalCount/pageSize);
		page.setTotalPage((int)totalPage);
		int begin=(currentPage-1)*pageSize;
		page.setList(departmentDao.findByPage(begin,pageSize));
		return page;
	}

	@Override
	public void save(Department department) {
		departmentDao.save(department);
		
	}

	@Override
	public Department findById(Integer did) {
		 return departmentDao.findById(did);
		
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Department dep) {
		departmentDao.delete(dep);
		
	}

	@Override
	public List<Department> getAll() {
		
		return departmentDao.getAll();
	}

}
