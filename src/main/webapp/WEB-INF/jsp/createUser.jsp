<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create A User</title>
</head>
<body>
<h1>Create A User</h1>
<form:form modelAttribute="user" action="/user/create" method="post">
    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" type="email" required="true"
                    pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"/>
    </div>
    <div>
        <form:label path="login">Login:</form:label>
        <form:input path="login" required="true"/>
    </div>
    <div>
        <button type="submit">Create a User</button>
    </div>
</form:form>
</body>
</html>