<%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 29.11.2020
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<!-- navbar -->
<nav class="navbar navbar-expand-lg fixed-top ">
    <a class="navbar-brand" href="#">Home</a>
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
    </div></nav>
<header class="header">
    <div class="overlay">
        <div class="container">
            <div class="row">
                <div class="description">
                    <h1> Easy finding<br>the best photographer</h1>
                    <p>    Taking an image, freezing a moment,
                        reveals how rich reality truly is
                    </p>
                    <form action="/signIn" target="_self">
                        <button class="btn btn-outline-secondary btn-lg" href="/signIn">Sign in</button>   </h1>

                    </form>
                    </div>
            </div>
        </div>
    </div>
</header>
<script type="text/javascript" src='js/main.js'></script>
</body>
</html>
