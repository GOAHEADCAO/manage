package com.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.Department;
import com.ssh.domain.PageBean;
import com.ssh.service.DepartmentService;

public class DepartmentAction extends SuperAction implements ModelDriven<Department>{

	private static final long serialVersionUID = 1L;
    private Department department=new Department();
    private DepartmentService departmentService;
    private Integer currentPage=1;
    
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	@Override
	public Department getModel() {
		return department;
	}
	public String findAll(){
		PageBean<Department> page=departmentService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(page);
		return "success";
	}
public String save(){
	departmentService.save(department);
	return "success";
	
}
public String edit(){
	department=departmentService.findById(department.getDid());
	return "success";
}
public String update(){
	departmentService.update(department);
	return "success";
}
  public String delete(){
	  Department dep=departmentService.findById(department.getDid());
	  departmentService.delete(dep);
	  return "success";
  }
}
