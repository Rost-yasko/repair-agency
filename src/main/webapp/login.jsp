<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>


body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.container {
    padding: 16px;
}

   h1 {color: red;}
}
</style>

<script>
function myFunction() {
    var x = document.getElementById("myInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
</script>

<div class="container">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>

<h1>${message}</h1>

<form method="post" action="Login">
      <label for="Login"><b>Login</b>
         <input type="text" placeholder="Enter Login" name="login" value="${Login}" required>
      </label>
      <label for="Password"><b>Password</b>
          <input type="password" placeholder="Enter Password" name="password" value="${Password}" id="myInput" required>
          <br><br>
          <input type="checkbox" onclick="myFunction()">Show Password
      </label>
           <button input type="submit" value="Submit">Login</button>

</from>
</div>
</html>


