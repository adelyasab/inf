<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 28.11.2020
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
</head>
<body>
<nav class="navbar navbar-expand-lg fixed-top">
    <a class="navbar-brand" href="/main">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarSupportedContent">     <ul class="navbar-nav mr-4">
        <li class="nav-item">
            <a class="nav-link" data-value="about" href="#">About</a>        </li>
        <li class="nav-item">
            <a class="nav-link " data-value="portfolio"href="#">Portfolio</a>
        </li>
        <li class="nav-item">
            <a class="nav-link " data-value="blog" href="#">Blog</a>         </li>
        <li class="nav-item">
            <a class="nav-link " data-value="team" href="#">         Team</a>       </li>
        <li class="nav-item">
            <a class="nav-link " data-value="contact" href="#">Contact</a>       </li>
    </ul>
    </div>
</nav>
<div class="frame-application"><div>

<form class="application" action="/application?photosession="+<%request.getAttribute("photosession_id");%> method="post" name="form">
    <ul class="ulul"><c:forEach items="${errors}" var="error">
    <li class="lili">${error.getMessage()}</li>
    </c:forEach>
    </ul>
        <label for="date">Date(click on the icon on the right)</label>
        <input class="form-styling" id="date" type="date" name="date" placeholder=""/>
        <label for="time">Time(click on the icon on the right)</label>
        <input class="form-styling" id="time" name="time" placeholder="" type="time"/>
        <label for="phonenumber">Phone number</label>
        <input class="form-styling" id="phonenumber" type="text" name="phonenumber" placeholder=""/>
        <label for="name">Name</label>
        <input class="form-styling" id="name" type="text" name="name" placeholder=""/>
        <input type="submit" class="superbutton" name="submit" value="Submit application"/>
</form>

</div>
</div>

</body>
</html>
