<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <title>Title</title>
</head>
<body>
<h3>Table Users</h3>

     <table border ="1">
<tr>
   <th>id</th>
   <th>firstName</th>
   <th>lastName</th>
   <th>email</th>
   <th>phone</th>
   <th>balance</th>
   <th>login</th>
   <th>password</th>
   <th>roleId</th>

      <ul>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.balance}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.roleId}</td>
                </tr>

            <li><c:out value="${user}" /></li>
            </c:forEach>
        </ul>
 </tr>
      </table>

</body>
</html>
