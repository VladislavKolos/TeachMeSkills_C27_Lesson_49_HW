<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Change User Login</title>
</head>
<body>
<h1>Change User Login</h1>
<form:form modelAttribute="user" action="/user/change-login" method="post">
    <div>
        <form:label path="id">User ID:</form:label>
        <form:input path="id" required="true"/>
    </div>
    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" type="email" required="true" pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"/>
    </div>
    <div>
        <form:label path="login">New Login:</form:label>
        <form:input path="login" required="true"/>
    </div>
    <div>
        <button type="submit">Change Login</button>
    </div>
</form:form>
</body>
</html>