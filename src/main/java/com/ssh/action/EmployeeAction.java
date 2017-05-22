package com.ssh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.Department;
import com.ssh.domain.Employee;
import com.ssh.domain.PageBean;
import com.ssh.service.DepartmentService;
import com.ssh.service.EmployeeService;

public class EmployeeAction extends SuperAction implements ModelDriven<Employee> {
private static final long serialVersionUID = 1L;
private Employee employee=new Employee();
private EmployeeService employeeService;
private DepartmentService departmentService;

public void setDepartmentService(DepartmentService departmentService) {
	this.departmentService = departmentService;
}
private int currentPage=1;

	public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}

	public void setEmployeeService(EmployeeService employeeService) {
	this.employeeService = employeeService;
}

	@Override
	public Employee getModel() {
		return employee;
	}
	
	public String login(){
		Employee employee1= employeeService.login(employee);
		if(employee1!=null){
			System.out.println("login success");
			session.setAttribute("employee", employee1);
			return "success";
		}
		System.out.println("login 峇佩阻。。。。。。。。。");
		return "failure";
	}
	public String findAll(){
		PageBean<Employee> page=employeeService.findByPage(currentPage);
		ActionContext.getContext().getValueStack().push(page);
		return "findAllSuccess";
	}
	public String save(){
		List <Department>list=departmentService.getAll();
		System.out.println(list.get(0).getDname());
		ActionContext.getContext().getValueStack().set("dlist", list);;
		return "saveSuccess";
	}
	public String add(){
		employeeService.add(employee);
		return "addSuccess";
	}
	
	public String edit(){
		employee=employeeService.findById(employee.getEid());
		List<Department>list =departmentService.getAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	public String update(){
		employeeService.update(employee);
		return "update";
	}
	public String delete(){
		employeeService.delete(employee);
		return "deleteSuccess";
	}

}
