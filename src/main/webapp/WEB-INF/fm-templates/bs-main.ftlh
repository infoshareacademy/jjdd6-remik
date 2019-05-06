<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TV programme</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/static/css/shop-item.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Do góry</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home</a>
                    <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <h3 class="my-4">Lista kanałów</h3>
            <div class="list-group">

                <#list channels as channel>
                    <a href="/programme/new?ch=${channel}" class="list-group-item">${channel!}</a>
                </#list>

            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <#attempt>
            <div class="card card-outline-secondary my-4">
                <div class="card-header">
                    <h1>${tvProgramme[1].channel!}</h1>
                </div>
            </div>
            <#recover>
            </#attempt>
            <!-- /.card -->

            <#list tvProgramme as item>

                <div class="card mt-4">
                    <div class="card-body">
                        <h3 class="card-title">${item.start!}</h3>
                        <h4>${item.titlePl!}<br></h4>
                        <#if item.director??>
                            <p class="card-text"><b>Reżyseria</b>: ${item.director!}</p>
                        </#if>
                        <#if item.actor??>
                            <p class="card-text"><b>Obsada:</b> ${item.actor!}</p>
                        </#if>
                        <#if item.country??>
                            <div class="card-text"><b>Produkcja:</b> ${item.country!}</div>
                        </#if>
                        <#if item.date?? && (item.date > 0) >
                            <p class="card-text"><b>Rok: </b>${item.date?c!}</p>
                        </#if>

                        <p class="card-text">${item.descPl!}</p>
                        <#if item.categoriesPl??>
                        </#if>

                        <#if item.rating != "" && item??>
                            Ocena:  <span class="text-warning">${item.rating!}</span>
                        </#if>
                        <p class="text-right">
                            <a href="#">
                                <img src="/static/images/calendar-svgrepo-com.svg" height="36" width="36">
                            </a>
                            <a href="/programme/find?tvItem=${item.id?c!}">
                                <img src="/static/images/newspaper-folded-svgrepo-com.svg" height="36" width="36">
                            </a>
                            <a href="/programme/details?id=${item.id?c!}">
                                <img src="/static/images/movie-camera-svgrepo-com.svg" height="36" width="36">
                            </a>
                        </p>

                    </div>
                </div>
            </#list>
            <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
    <#include "copyright-footer.ftlh">
</footer>

<!-- Bootstrap core JavaScript -->
<script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
