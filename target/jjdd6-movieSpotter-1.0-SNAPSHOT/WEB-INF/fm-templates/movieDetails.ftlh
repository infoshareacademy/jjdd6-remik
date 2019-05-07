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
<#include "header.ftlh">
<!-- Navigation -->


<!-- Page Content -->
<div class="container">
    <div class="row">

        <div class="col-lg-3">
            <h3 class="my-4">&nbsp;</h3>
            <div class="list-group">
                <#attempt>
                    <a href=${m_movie.websiteURL!} class="list-group-item">Strona filmu na filmweb.pl</a>
                    <#recover>
                </#attempt>
                <a href="/" class="list-group-item">Wróć do programu</a>
            </div>
        </div>

        <div class="col-lg-9">

            <#if m_movie??>
                <div class="card card-outline-secondary my-4">
                    <div class="card-header">
                        <table>
                            <tr>
                                <td>

                                    <#attempt>
                                        <img src=${m_movie.posterURL!}>
                                        <#recover>
                                    </#attempt>
                                </td>
                                <td>
                                    <#attempt>
                                <td width="100%">
                                    <ul>
                                        <li>${m_movie.polishTitle!}</li>
                                        <li>${m_movie.title!}</li>
                                        <li>${m_movie.year?c!}</li>
                                        <li>${m_movie.rate}/${m_movie.votes?c}</li>
                                        <li><a href=${m_movie.websiteURL!}>Strona filmu na filmweb.pl</a></li>
                                        <li>${m_movie.plot!}</li>
                                        <#if m_movie.genres??>
                                        <li>${m_movie.genres!}</li>
                                    </ul>
                                    </#if>
                                </td>
                                <#recover>
                                </#attempt>

                                </td>
                            </tr>
                        </table>
                    </div>
                </div>



                <div class="card card-outline-secondary my-4">
                    <div class="card-header">

                        <#attempt>
                            <#list m_persons as p>
                                <div>
                                    <#if p == m_persons[0]>

                                        <b>${p.role!"Reżyseria"}</b> - ${p.name} ${p.info!}
                                        <br><br>
                                    <#else>
                                        <b>${p.role!" --- "}</b> - ${p.name} ${p.info!}
                                    </#if>
                                </div>
                            </#list>
                            <#recover>
                        </#attempt>
                    </div>
                </div>
            </#if>
            <!-- /.card -->

            <#attempt>
                <div class="card mt-4">
                    <div class="card-body">
                        <h4 class="card-title">Filmy pasujące do wyszukiwania:</h4>


                        <div>

                            <br>
                            <#list movies as m>
                                <li>${m.polishTitle!} (${m.title!}) ${m.year?c!} <a
                                            href="/programme/movie?fwID=${m.id?c!}">szukaj w movieSpotter</a></li>
                            </#list>
                        </div>


                    </div>
                </div>
                <#recover>
            </#attempt>

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