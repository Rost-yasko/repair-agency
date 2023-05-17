<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: black;
}

* {
    box-sizing: border-box;
}

/* Add padding to containers */
.container {
    padding: 16px;
    background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 15px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Overwrite default styles of hr */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}

/* Set a style for the submit button */
.register {
    background-color: #4CAF50;
    color: white;
    padding: 16px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
}
.register:hover {
    opacity: 1;
}

 p {color: blue;}
 h3 {color: red;}
 h1 {color: green;}

</style>
</head>

  <div class="container">
<head>
  <meta charset="UTF-8">
   <title>Add new user</title>
</head>
    <center> <h1>Register</h1> </center>
 <p> Please fill in this form to create an account.</p>
<hr></hr>
<h3>${message}</h3>
<form method="post" action="AddUser">
   <label for="FirstName"><b>FirstName</b>
       <input type="text" placeholder="Enter first name" name="firstName" value="${firstName}" required><br />
   </label>

   <label for="LastName"><b>LastName</b>
       <input type="text"placeholder="Enter last name" name="lastName" value="${lastName}" required><br />
   </label>

   <label for="Email"><b>Email</b>
       <input type="text" placeholder="Enter email" name="email" value="${email}" required><br />
   </label>

   <label for="Phone"><b>Phone</b>
       <input type="text" placeholder="Enter phone" name="phone" value="${phone}" required><br />
   </label>

   <label for="Balance"><b>Balance</b>
       <input type="text" placeholder="Enter balance" name="balance" value="${balance}" required><br />
   </label>

   <label for="Login"><b>Login</b>
       <input type="text" placeholder="Enter login" name="login" required><br />
   </label>

   <label for="Password"><b>Password</b>
       <input type="password" placeholder="Enter password" name="password" required><br />
   </label>
        <button input type="submit" class="register" value="Submit">Register</button>

</form>
   </div>
</html>