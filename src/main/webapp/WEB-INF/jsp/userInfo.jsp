<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>User Info</title>
</head>

<body>
<h2>User Info:</h2>
<c:if test="${user != null}">
    User ID: ${user.id}<br>
    Email: ${user.email}<br>
    Login: ${user.login}<br>
</c:if>
<c:if test="${user == null}">
    <h2>User is not found</h2>
</c:if>
</body>

</html>
