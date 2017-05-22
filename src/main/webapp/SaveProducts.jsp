<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>保存商品</title>
</head>
<body>
<s:form action="product_save.action" namespace="/" method="post" theme="simple">
<table width="400px" border="1">
<tr><td >商品名称：<s:textarea name="pname"></s:textarea></td></tr>
<tr><td >商品价格:<s:textarea name="price"></s:textarea></td></tr>
<tr><td colspan="2"><s:submit value="保存"></s:submit></td></tr>
</table>
</s:form>
</body>
</html>