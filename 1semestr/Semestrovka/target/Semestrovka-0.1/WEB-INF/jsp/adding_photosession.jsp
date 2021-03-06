<%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 27.11.2020
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding photosession</title>
</head>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Adding photosession</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"><
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
<div class="frame-adding"><div>
    <form method="post" enctype="multipart/form-data" action="/addingPhotosession">

        <label for="price">Price(rub)</label>
        <input class="form-styling" maxlength="99" minlength="1" id="price" type="number" name="price"/>
        <label for="name">Photosession name</label>
        <input class="form-styling" maxlength="99" minlength="1" id="name" type="text" name = "name">
        <label for="photos">Choose type of photsession</label>
        <select class="form-styling" multiple class="form-control" id="photos" size="4" multiple name="type_photo">
            <option value="love">Love story</option>
            <option selected value="family">Family</option>
            <option value="friends">Friends</option>
            <option value="individual">Individual</option>
        </select>
        <input type="file" name="file" id="file" class="input-file">
        <label for="file" class="btn btn-tertiary js-labelFile">
            <i class="icon fa fa-check"></i>
            <span class="js-fileName">Add main photo</span>
        </label>
        <label for="send"></label>
        <input class="form-styling" id="send" class="superbutton" type="submit" value="Add photosession">
    </form>
</div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath}js/sign.js'></script>
</body>
</html>
