<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Basic JSP Page</title>
</head>
<body>
    <h3>Hello, World!</h3>
    <%-- JSP Scriptlet to include Java code --%>
    <% java.util.Date date = new java.util.Date(); %>

    <%-- JSP Expression to output dynamic content --%>
    <strong>Current Time is</strong>: <%= date %>
</body>
</html>
