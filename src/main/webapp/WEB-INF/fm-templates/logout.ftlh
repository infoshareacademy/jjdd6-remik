<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>movieSpotter::signinIn</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/static/css/shop-item.css" rel="stylesheet">


    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>

    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id"
          content="399480466285-afre19aq1pr80q26iadomq8kmo2llj2o.apps.googleusercontent.com">
    <script src="/static/js/googleSignin.js"></script>
    <link href="/static/css/ChannelMenuWithFavorites.css" rel="stylesheet">
    <#--    <div align="right" class="row h-100 justify-content-center align-items-center">-->
    <#--        <a href="/programme/account/logout" onclick="signOut();">Wyloguj</a>-->
    <#--    </div>-->


</head>
<html>
<body>

<#include "header.ftlh">

<div class="container">

    <div class="row">

<#--        <div class="col-lg-3">-->

<#--            &lt;#&ndash;            <#include "ChannelsMenuWithFavorites.ftlh">&ndash;&gt;-->

<#--            <div class="list-group">-->
<#--                <div class="list-group-item">-->
<#--                    left-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->

<#--        <div class="col-lg-9">-->

            <div class="col-lg-12">
            <div class="card card-outline-secondary my-4">
                <div class="card-header">
                    <h4>

                        <div align="right" class="row h-100 justify-content-center align-items-center">
                            <p>Witaj, ${user!}</p>
                        </div>
                        <div align="right" class="row h-100 justify-content-center align-items-center">
                            <a href="/programme/account/logout" onclick="signOut();">Wyloguj</a>
                        </div>
                    </h4>
                </div>
            </div>

            <!-- /.card -->
                <#list movies as m>
            <div class="card mt-4">
                <div class="card-body">
                    <table>
                        <tr>
                            <td width="0%">
                                <#if m.poster??>
                                    <img src="${m.poster!}">
                                </#if>
                            </td>
                            <td width="100%">
                    <h4 class="card-title">${m.polishTitle!}
                        <button class="fav-mov-button" id="${m.filmWebId?c!}"
                                onclick="favoritesMov(${m.filmWebId?c!})">★</button>
                    </h4>
                    <h5>${m.title!}<br></h5>
                    <a href="${m.url!}">strona filmu na filmwebie</a>
                            </td>
                        </tr>
                    </table>
                </div>

            </div>
                </#list>
            <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>

<footer class="py-5 bg-dark">
    <#include "copyright-footer.ftlh">
</footer>

<script src="/static/js/favorites.js"></script>
<script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
