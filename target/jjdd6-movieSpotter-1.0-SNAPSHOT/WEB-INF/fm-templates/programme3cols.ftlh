<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>TV programme</title>
    <style>
        .column {
            float: left;
            width: 33.33%;
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
    </style
</head>
<body>

<#-- text -->
<div class=row>
    <#list programmes as programme>

        <#if programme.channel == channels[0]>
            <div class=column name=1>
                <ul>
                    <li>Program: ${programme.channel!}</li>
                    <li>Tytuł: ${programme.titlePl!}</li>
                    <li>Start: ${programme.start!}</li>
                    <li>Opis: ${programme.descPl!}</li>
                    <li>Reżyseria: ${programme.director!}</li>
                    <li>Obsada: ${programme.actor!}</li>
                    <li>Rok: ${programme.date?c!}</li>
                    <li>Kategoria: ${programme.categoriesPl!}</li>
                    <li><a href="/programme?id=${programme.id?c!}">Szczegóły</a></li>
                </ul>
            </div>
        </#if>



        <#if programme.channel == channels[1]>
            <div class=column name=2>

                <ul>
                    <li>Program: ${programme.channel!}</li>
                    <li>Tytuł: ${programme.titlePl!}</li>
                    <li>Start: ${programme.start!}</li>
                    <li>Opis: ${programme.descPl!}</li>
                    <li>Reżyseria: ${programme.director!}</li>
                    <li>Obsada: ${programme.actor!}</li>
                    <li>Rok: ${programme.date?c!}</li>
                    <li>Kategoria: ${programme.categoriesPl!}</li>
                    <li><a href="/programme?id=${programme.id?c!}">Szczegóły</a></li>
                </ul>
            </div>
        </#if>


        <#if programme.channel == channels[2]>
            <div class=column name=3>

                <ul>
                    <li>Program: ${programme.channel!}</li>
                    <li>Tytuł: ${programme.titlePl!}</li>
                    <li>Start: ${programme.start!}</li>
                    <li>Opis: ${programme.descPl!}</li>
                    <li>Reżyseria: ${programme.director!}</li>
                    <li>Obsada: ${programme.actor!}</li>
                    <li>Rok: ${programme.date?c!}</li>
                    <li>Kategoria: ${programme.categoriesPl!}</li>
                    <li><a href="/programme?id=${programme.id?c!}">Szczegóły</a></li>
                </ul>
            </div>
        </#if>
    </#list>
</div>




<#include "copyright-footer.ftlh">
</body>
</html>