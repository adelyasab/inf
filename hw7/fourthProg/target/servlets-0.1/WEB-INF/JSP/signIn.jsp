<%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 11.10.2020
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
</head>
<body>
<form action="/signIn" method="post">
    <label for="login_input", for="password_input">Sign In</label>
    <br>
    <h3>Input login:</h3>
    <input id="login_input" name="login_input" placeholder="Your login">
    <br>
    <h3>Input your password:</h3>
    <input id="password_input" name="password_input" placeholder="Your password">
    <br>
    <input type="submit" value="Send!">
    <p> <%= request.getAttribute("user") %></p>
</form>

</body>
</html>
