<%@ page import="ru.itis.models.User" %>
<%@ page import="ru.itis.models.Photo" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.itis.models.Photosession" %>
<%@ page import="ru.itis.models.PhotosessionPlusPhoto" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Аделюша
  Date: 07.11.2020
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/profile.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Profile</title>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
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
<% User user = (User)request.getAttribute("userForProfile");
    System.out.println(user.getFirstname());
    Photo photo =  (Photo)request.getAttribute("photoOfProfile");
%>

<div class="row py-5 px-4">
    <div class="col-md-5 mx-auto">
        <!-- Profile widget -->
        <div class="bg-white shadow rounded overflow-hidden">
            <div class="px-4 pt-0 pb-4 cover">
                <div class="media align-items-end profile-head">
                    <div class="profile mr-3"><img src="${pageContext.request.contextPath}/image?name=<%=photo.getStorageFileName()%>.<%=photo.getType().split("/")[1]%>" alt="..." width="130" class="rounded mb-2 img-thumbnail">
                        <a href="/main" class="btn btn-outline-dark btn-sm btn-block">Exit</a></div>
                    <div class="media-body mb-5 text-white">
                        <h4 class="mt-0 mb-0"><%=user.getFirstname() + " " + user.getLastname()%></h4>
                        <p class="small mb-4"> <i class="fas fa-map-marker-alt mr-2"></i></p>
                    </div>
                </div>
            </div>
            <div class="bg-light p-4 d-flex justify-content-end text-center">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item">
                        <h5 class="font-weight-bold mb-0 d-block"><%=request.getAttribute("submittedApplication")%></h5>
                        <small class="text-muted"> <i class="fas fa-image mr-1"></i>submitted applications</small>
                    </li>
                    <li class="list-inline-item">
                        <h5 class="font-weight-bold mb-0 d-block"><%=request.getAttribute("adoptedApplication")%></h5>
                        <small class="text-muted"> <i class="fas fa-user mr-1"></i>adopted applications</small>
                    </li>
                    <li class="list-inline-item">
                        <h5 class="font-weight-bold mb-0 d-block"><%=request.getAttribute("photosessions")%></h5>
                        <small class="text-muted"> <i class="fas fa-user mr-1"></i>photosessions in profile</small>
                    </li>
                </ul>
            </div>
            <div class="px-4 py-3">
                <h5 class="mb-0">Actions</h5>
                <div class="p-4 rounded shadow-sm bg-light">
                    <a href="/allPhotosession" class="font-italic mb-0">Sign up for a photosessions</a><br>
                    <a href="/addingPhotosession" class="font-italic mb-0">Add your photosession</a>
                </div>
            </div>
            <div class="py-4 px-4">
                <div class="d-flex align-items-center justify-content-between mb-3">
                    <h5 class="mb-0">Photosessions</h5>
                </div>
                <div class="row">
                    <% List<Photosession> photosessions = (List<Photosession>)request.getAttribute("photosessionsForProfile");
                    for (int i = 0; i < photosessions.size(); i++){
                        List<PhotosessionPlusPhoto> ppp = (List<PhotosessionPlusPhoto>) request.getAttribute("photosessionsPlusPhotos");
                        List<PhotosessionPlusPhoto> p = new ArrayList<>();
                        for (int j = 0; j < ppp.size(); j++) {
                            if (ppp.get(j).getIdPhotoset() == photosessions.get(i).getId()) {
                                p.add(ppp.get(j));
                            }
                        }
                        if (p.size() > 0) {
                    %>
                    <div class=" card col-lg-6 mb-2 pr-lg-1">
                    <div id="carouselExampleControls<%=i%>" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active img-fluid rounded shadow-sm">
                                <img class="img-fluid rounded shadow-sm" src="${pageContext.request.contextPath}/image?name=<%=p.get(0).getStorageName()%>.<%=p.get(0).getType().split("/")[1]%>" alt="Первый слайд">
                            </div>
                            <% for (int j = 1; j < p.size(); j++) { %>
                            <div class="carousel-item img-fluid rounded shadow-sm">
                                <img  class="img-fluid rounded shadow-sm" src="${pageContext.request.contextPath}/image?name=<%=p.get(j).getStorageName()%>.<%=p.get(j).getType().split("/")[1]%>" alt="Второй слайд">
                            </div>
                            <% } %>
                        </div>
                        <a id = "carousel-control-prev<%=i%>" class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a id ="carousel-control-next<%=i%>" class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                        <div class="card-body">
                            <a href="/uploading?photosession=<%=photosessions.get(i).getId()%>">Add photos</a>
                        </div>
                    </div>
                    <script>
                        $(document).ready(function(){
                            // Activate Carousel
                            $("#carouselExampleControls<%=i%>").carousel();


                            // Enable Carousel Controls
                            $("#carousel-control-prev<%=i%>").click(function(){
                                $("#carouselExampleControls<%=i%>").carousel("prev");
                            });
                            $("#carousel-control-next<%=i%>").click(function(){
                                $("#carouselExampleControls<%=i%>").carousel("next");
                            });
                        });</script>

                            <% }
                    }%>
                </div>
            </div>
        </div>
    </div>
</div>
    </div>

    <!-- jQuery -->


</body>
</html>