<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
    <script src="/js/main.js"></script>
</head>
<body>
<!--<form action="/signUp" method="post">
    <input name="email" type="email" placeholder="EMAIL">
    <input name="password" type="password" placeholder="PASSWORD">
    <input type="submit" value="SIGN UP">
</form> -->
<div class="big"><div class="container">
        <div class="frame">
            <div class="nav">
                <ul class="links">
                    <li class="signin-inactive"><a href="/signIn" class="text">Sign in</a></li>
                    <li class="signup-active"><a class="text">Sign up </a></li>
                </ul>
            </div>

            <form class="form-signup" action="/signUp" enctype="multipart/form-data" method="post" name="form">
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
                <!--<input type="file" required name="file" id="file" class="input-file">
                <label for="file" class="btn btn-tertiary js-labelFile">
                    <i class="icon fa fa-check"></i>
                    <span class="js-fileName">Upload profile photo</span>
                </label> -->
                <label for="sign-upp"></label>
                <input type="submit" class="superbutton" id="sign-upp" name="submit" value="Sign up" />
            </form>


        </div>
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
</body>
</html>