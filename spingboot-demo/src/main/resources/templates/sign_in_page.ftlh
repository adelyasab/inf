<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
    <script src="/js/main.js"></script>
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
<div class="frame-signin">
    <div class="nav">
        <ul class="links">
            <li class="signin-active"><a class="text">Sign in</a></li>
            <li class="signup-inactive"><a href="/signUp" class="text">Sign up </a></li>
        </ul>
    </div>
    <div>
        <form class="form-signin" action="/signIn" enctype="multipart/form-data" method="post" name="form">
            <label for="email">Email</label>
            <input class="form-styling" id="email" maxlength="99" minlength="1" type="email" name="email"/>
            <label for="password">Password</label>
            <input class="form-styling" id = "password" type="password" name="password"/>
            <input class= "custom-checkbox" maxlength="99" minlength="1" type="checkbox" id="checkbox"/>
            <label for="checkbox">I am agree with the site rules</label>
            <input type="submit" class="superbutton" href="/profile" name="submit" value="Sign in" />
        </form>
    </div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.14/angular.min.js'></script>
<script type="text/javascript" src='/js/main.js'></script>
</body>
</html>