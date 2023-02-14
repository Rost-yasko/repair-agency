<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>firs JSP</title>
</head>
<body>
<h1>Testing JSP</h1>
<p>
<% String name = request.getParameter("name"); %>
<%= "Hello, " + name %>
</p>
</body>
</html>