package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.dao.DepartmentDao;
import com.ssh.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public Integer findCount() {
		String hql="select count(*) from Department ";
		List<Long> list= (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			System.out.println("有多少条记录》》》》》》》》"+list.get(0).intValue());
		return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
	DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
	List <Department> list=(List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
		
	}

	@Override
	public Department findById(Integer did) {
		 return this.getHibernateTemplate().get(Department.class, did);
		
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
		
	}

	@Override
	public void delete(Department dep) {
		this.getHibernateTemplate().delete(dep);
		
	}

	@Override
	public List<Department> getAll() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}



}
