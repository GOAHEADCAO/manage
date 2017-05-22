<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
        .table1{
            border:1px solid #ddd;
            width:900px;
            
        }
        thead{
            background-color:lightblue;
        }

    </style>
</head>
<body>
<table border="0" width="900px">
<tr>
<td align="center" style="font-size:24px; color:#666"> 员工管理</td>
</tr>
<tr>
<td align="right" > <a href="${pageContext.request.contextPath}/employee_save.action">添加</a></td>
</tr>
</table>
<br/>


<table cellspacing="0" border="1" class="table1">
<thead>
  <tr>
<td align="center">编号</td>
<td align="center">员工姓名</td>
<td align="center">性别</td>
<td align="center">出生日期</td>
<td align="center">入职时间</td>
<td align="center">所属部门</td>
<td align="center">编辑</td>
<td align="center">删除</td>

</tr>
</thead>
<tbody>
<s:iterator var="emp" value="list">
<tr>
<td align="center"><s:property value="#emp.eno" /></td>
<td align="center"><s:property value="#emp.ename" /></td>
<td align="center"><s:property value="#emp.sex" /></td>
<td align="center"><s:property value="#emp.birthday" /></td>
<td align="center"><s:property value="#emp.joinDate" /></td>
<td align="center"><s:property value="#emp.department.dname" /></td>
<td align="center"><a href="${pageContext.request.contextPath}/employee_edit?eid=<s:property value="#emp.eid"/>"><img src="${pageContext.request.contextPath}/images/编辑.png"/></a></td>
<td align="center"><a href="${pageContext.request.contextPath}/employee_delete?eid=<s:property value="#emp.eid"/>">删除</a></td>

</tr>
</s:iterator>
</tbody>
</table>
<br/>

<table border="0" cellspacing="0" cellpadding="0"  width="900px">
<tr>
<td align="right">
   <span>第${currentPage }/${totalPage}页</span>
   <span>
   <s:if test="currentPage!=1">
       <a href="${pageContext.request.contextPath }/employee_findAll?currentPage=1">[首页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/employee_findAll?currentPage=${currentPage-1}">[上一页]</a>&nbsp;&nbsp;
       </s:if>
       <s:if test="currentPage!=totalPage">
       <a href="${pageContext.request.contextPath }/employee_findAll?currentPage=${currentPage+1}">[下一页]</a>&nbsp;&nbsp;
       <a href="${pageContext.request.contextPath }/employee_findAll?currentPage=${totalPage}">[尾页]</a>&nbsp;&nbsp;
       </s:if>
   </span>
</td>
</tr>
</table>
</body>
</html>