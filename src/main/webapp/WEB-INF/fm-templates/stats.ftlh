<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

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


    <script>

        window.onload = function() {

            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title: {
                    text: "Najczęściej wyświetlane kanały:"
                },
                data: [{
                    type: "pie",
                    startAngle: 45,
                    yValueFormatString: "##0.00\"%\"",
                    indexLabel: "{label} {y}",
                    dataPoints: [

                        <#list Channels as channel>
                        {y: ${channel.clickCounterPercentage}, label: "${channel.name}"},
                        </#list>
                        //{y:0, label:""}

                        // {y: 79.45, label: "Google"},
                        // {y: 7.31, label: "Bing"},
                        // {y: 7.06, label: "Baidu"},
                        // {y: 4.91, label: "Yahoo"},
                        // {y: 1.26, label: "Others"}
                    ]
                }]
            });
            chart.render();

        }
    </script>

</head>
<html>
<body>


<#include "header.ftlh">

<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <form class="col-12">
            <div class="align-content-md-center">
                <div id="chartContainer" style="height: 370px; width: 100%;"></div>

                <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

            </div>
        </form>
    </div>
</div>

<footer class="py-5 bg-dark">
    <#include "copyright-footer.ftlh">
</footer>

    <script src="/static/vendor/jquery/jquery.min.js"></script>
<script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
