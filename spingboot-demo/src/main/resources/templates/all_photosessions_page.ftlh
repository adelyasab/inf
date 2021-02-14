<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"> </script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>

</head>
<body>
<script>
    function rendering(photosessions, container){
        let innerHTML = '<div class=\"row\">';
        for (let i = 0; i < photosessions.length; i++) {
            innerHTML += '<div class=\"card rounded shadow-sm\">';
           innerHTML += '<div class="card-body">';
            innerHTML += photosessions[i]['photosessionName'];
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
            url: "/photosessions",
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
