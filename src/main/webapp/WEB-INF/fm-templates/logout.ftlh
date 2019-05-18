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

</head>
<html>
<body>


<#include "header.ftlh">

<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <a href="/programme/account/logout" onclick="signOut();">Sign out</a>
    </div>
</div>

<footer class="py-5 bg-dark">
    <#include "copyright-footer.ftlh">
</footer>

<script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
