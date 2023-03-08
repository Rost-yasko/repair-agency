
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
     It is test servlet page!
<p>
     <%@ page import="dao.implementation.UserDao" %>
     <% UserDao userDao = new UserDao(); %>
     <%= userDao.getAll() %>

</p>
</body>
</html>