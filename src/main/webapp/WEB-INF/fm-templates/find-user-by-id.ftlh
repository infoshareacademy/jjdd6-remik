<!DOCTYPE html>
<html>
<head>
    <title>Find User By Id</title>
</head>
<body>

<!-- This is HTML comment example -->
<#-- This is FTL comment example -->
<#if errorMessage??>
    <span style="color: #ff0000;">${errorMessage}</span><br/><br/>
</#if>

<#if user??>
    <ul>
        <li>ID: ${user.id}</li>
        <li>Name: ${user.name}</li>
        <li>Login: ${user.login}</li>
        <li>Age: ${user.age}</li>
        <li>Gender: ${user.gender}</li>
        <li>Pulse: ${pulse}</li>
    </ul>
</#if>

<#include "copyright-footer.ftlh">
</body>
</html>