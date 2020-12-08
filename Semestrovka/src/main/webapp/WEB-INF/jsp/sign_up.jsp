<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 11.10.2020
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign up</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
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
            <a class="nav-link " data-value="portfolio" href="#">Portfolio</a>
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
<div class="big"><div class="container">
    <div class="frame">
        <div class="nav">
            <ul class="links">
                <li class="signin-inactive"><a href="/signIn" class="text">Sign in</a></li>
                <li class="signup-active"><a class="text">Sign up </a></li>
            </ul>
        </div>

        <form class="form-signup" action="" enctype="multipart/form-data" method="post" name="form">
            <label for="email">Email</label>
            <input class="form-styling" required maxlength="99" minlength="1" id="email" type="email" name="email" placeholder=""/>
            <label for="firstname">Firstname</label>
            <input class="form-styling" required maxlength="99" minlength="1" id="firstname" type="text" name="firstName" placeholder=""/>
            <label for="lastname">Lastname</label>
            <input class="form-styling" required maxlength="99" minlength="1" id="lastname" type="text" name="lastName" placeholder=""/>
            <label for="password">Password</label>
            <input class="form-styling" required id="password" maxlength="99" minlength="1" type="password" name="password" placeholder=""/>
            <label for="confirmpassword">Confirm password</label>
            <input class="form-styling" required type="password" maxlength="99" minlength="1" id="confirmpassword" name="confirmpassword" placeholder=""/>
            <input type="file" required name="file" id="file" class="input-file">
            <label for="file" class="btn btn-tertiary js-labelFile">
                <i class="icon fa fa-check"></i>
                <span class="js-fileName">Upload profile photo</span>
            </label>
            <label for="sign-upp"></label>
            <input type="submit" class="superbutton" id="sign-upp" name="submit" value="Sign up" />
        </form>


    </div>
    <ul>
    <c:forEach items="${errors}" var="error">
        <li>${error.getMessage()}</li>
    </c:forEach>
</ul>
</div>
</div>


<script>
    $(document).ready(function(){
        // Activate Carousel
        $("#carouselExampleControls").carousel();


        // Enable Carousel Controls
        $("#carousel-control-prev").click(function(){
            $("#carouselExampleControls").carousel("prev");
        });
        $("#carousel-control-next").click(function(){
            $("#carouselExampleControls").carousel("next");
        });
    });
</script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath}js/sign.js'></script>
</body>
</html>
