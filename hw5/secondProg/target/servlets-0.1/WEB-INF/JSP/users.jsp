<%@ page import="ru.itis.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 26.09.2020
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Age</th>
    </tr>

    <% List<User> users = (List<User>)request.getAttribute("UsersForJSP");
        for (int i = 0; i < users.size(); i++){%>
    <tr>
        <td><%=users.get(i).getId()%></>
        <td><%=users.get(i).getFirstname()%></>
        <td><%=users.get(i).getLastname()%></>
        <td><%=users.get(i).getAge()%></>
    </tr>
    <%}%>

</table>

</body>
</html>
