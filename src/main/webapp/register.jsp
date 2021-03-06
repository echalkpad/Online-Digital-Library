<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线数字图书馆用户注册</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
	<style type="text/css">
	</style>
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
</head>  
<body>
<div class="container">
<jsp:include page="navigation.jsp"></jsp:include> 
<form method="post" action="/saveUser.do">
<div class="hero-unit">
<h3>用户注册</h3>
<table class="">
    <tr>
    	<td>用户名</td>
    	<td><form:input path="user.username" cssClass="input-xlarge" placeholder="用户名：user"></form:input>
            <form:errors cssClass="error text-error" path="user.username"></form:errors>
    	</td></tr>
    <tr>
    	<td>真实名</td>
    	<td><form:input path="user.realName" cssClass="input-xlarge" placeholder="真实名：张三"></form:input>
            <form:errors cssClass="error text-error" path="user.realName"></form:errors>
    	</td></tr>
    <tr>
    	<td>密码</td>
    	<td><form:password path="user.password" cssClass="input-xlarge" placeholder="密码：XXXXXX"></form:password>
            <form:errors cssClass="error text-error" path="user.password"></form:errors>
        </td></tr>
    <tr>
    	<td>邮箱</td>
    	<td><form:input path="user.email" cssClass="input-xlarge" placeholder="邮箱：test@yahoo.com"></form:input>
            <form:errors cssClass="error text-error" path="user.email"></form:errors>
		</td></tr>
    <tr><td colSpan="2" align="center">
    	<input type="submit" value="提交" class="btn"/>
    	&nbsp;<a class="btn" href="/index.do">返回</a> </td></tr>
</table>
</div>
</div>
</form>  
</body>
<script type="text/javascript">
    
   if(${!empty param.message})
		alert('${param.message}');
</script> 
</html> 