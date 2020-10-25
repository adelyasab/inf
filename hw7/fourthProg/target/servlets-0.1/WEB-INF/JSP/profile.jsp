<%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 07.10.2020
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="color: ${cookie.get("color").value}">It's your profile</h1>
<form action = "/profile" method = "post">
    <select name= "color" >
        <option value = "red">Red</option>
        <option value = "green">Green</option>
        <option value = "Blue">Blue</option>
    </select>
    <input type="text" placeholder="SomeString">
    <input type="submit" value="OK">
</form>

</body>
</html>
