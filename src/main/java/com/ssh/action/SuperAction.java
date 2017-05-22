package com.ssh.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public class SuperAction extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, ServletContextAware {

	private static final long serialVersionUID = 1L;
protected HttpServletRequest requetst;
protected HttpServletResponse response;
protected HttpSession session;
protected ServletContext context;

	@Override
	public void setServletContext(ServletContext arg0) {
		this.context=arg0;

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {	
     this.response=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
this.requetst=arg0;
this.session=arg0.getSession();
	}

}
