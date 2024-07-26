<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Delete User</title>
</head>
<body>
<h1>Delete User</h1>
<form:form modelAttribute="user" action="/user/delete" method="post">
    <div>
        <form:label path="id">User ID:</form:label>
        <form:input path="id" required="true"/>
    </div>
    <div>
        <button type="submit">Delete User</button>
    </div>
</form:form>
</body>
</html>