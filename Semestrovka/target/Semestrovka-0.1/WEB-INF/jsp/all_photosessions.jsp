<%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 28.11.2020
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Photosessions</title>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"> </script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<script>
    function rendering(photosessions, container){
        let innerHTML = '<div class=\"row\">';
        for (let i = 0; i < photosessions.length; i++) {
            innerHTML += '<div class=\"card rounded shadow-sm\">';
            innerHTML += '<img src=\"/image?name=' + photosessions[i]['photo_storage_name'] + '.' + photosessions[i]['photo_type'].split("/")[1] + '\" alt=\"\" class=\"card-img-top\">';
            innerHTML += '<div class="card-body">';
            innerHTML += photosessions[i]['photosession_name'];
            innerHTML += '<a href=\"/application?photosession=' + photosessions[i]['id'] + '\"> Sign up photosession</a>';
            innerHTML +='</div></div>';
            console.log(innerHTML);
        }
        innerHTML += '</div>';
        container.html(innerHTML);
    }
    function showPhotosets() {
        let data= {
            "price" : $('#price').val(),
            "type" : $('#type').val()[0]
            };
        console.log($('#price').val());
        console.log($('#type').val()[0]);
        $.ajax({
            type: "POST",
            url: "/allPhotosession",
            data: JSON.stringify(data),
            success: function (response){
                rendering(response, $('#container'))
            },
            dataType: "json",
            contentType: "application/json",
            encoding: "UTF-8"
        });
    }
</script>
<div>
    <input type="number" id="price" value="1000" onkeyup= "showPhotosets()">
    <select size="5" multiple name="type" id="type" onclick="showPhotosets()">
        <option selected value="all">All</option>
        <option value="love">Love story</option>
        <option value="family">Family</option>
        <option value="friends">Friends</option>
        <option value="individual">Individual</option>
    </select>
</div>
<div class="container" id="container">

</div>
</body>
</html>
