<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Movie Details</title>
    <style>
        .column {
            float: left;
            width: 66.33%;
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
<table width="75%">
    <tr>
        <td width="5%">

            <#attempt>
            <img src=${m_movie.posterURL!}>
            <#recover>
            </#attempt>
        </td>
        <#attempt>
        <td width="100%">
            <ul>
                <li>${m_movie.polishTitle!}</li>
                <li>${m_movie.title!}</li>
                <li>${m_movie.year!}</li>
                <li>${m_movie.rate}/${m_movie.votes?c}</li>
                <li><a href=${m_movie.websiteURL!}>Strona filmu na filmweb.pl</a></li>
                <li>${m_movie.plot!}</li>
                <li>${m_movie.genres!}</li>

            </ul>
        </td>
        <#recover>
        </#attempt>
    </tr>
</table>
<#attempt>
<#list m_persons as p>
<div = row>${p.role!"Reżyseria"} - ${p.name} ${p.info!}
</div>
    </#list>
<#recover>
</#attempt>

<#attempt>
<div>
    <br><br>
    pasujące filmy:
    <br>
<#list movies as m>
    <li>${m.polishTitle!}  (${m.title!})  ${m.year?c!} <a href="/movie?fwID=${m.id?c!}">szukaj w movieSpotter</a></li>
</#list>
</div>
<#recover>
</#attempt>

<#include "copyright-footer.ftlh">
</body>
</html>