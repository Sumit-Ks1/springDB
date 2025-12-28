<%@ page import="com.sumit.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My First JSP Page</title>
</head>
<body>

    <%
        User user =(User) session.getAttribute("session_user");
    %>
    <h1>Welcome <%= user.getName() %></h1>
    <br>
    <h2> Here are your profile details- </h2>
    <br>
    <h3>Email- <%= user.getEmail()%> </h3>
    <h3>City- <%= user.getCity()%> </h3>

    <a href="logout"> Logout </a>
</body>
</html>
