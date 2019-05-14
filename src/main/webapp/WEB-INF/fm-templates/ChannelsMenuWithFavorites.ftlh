<link href="/static/css/ChannelMenuWithFavorites.css" rel="stylesheet">
<script src="/static/js/favorites.js"></script>

<h3 class="my-4">Lista kanałów</h3>
<div class="list-group">
    <#--                <form method="post" onsubmit="/programme/fav">-->

    <#attempt>
    <#assign x = usersFavorites>
        <#recover>
    </#attempt>


    <#list channels as channel>
        <div class="list-group-item">
            <#attempt>
            <button  class="favbutton" id="${channel.id!}" onclick="favorites('${channel.id!}')">${x?seq_contains(channel.id)?string("★","☆")}</button>
            <#recover>
            </#attempt>
            <a href="/programme/new?ch=${channel.name?url}">${channel.name!}</a>
        </div>
    </#list>
    <#--                style="font-size: 12px"-->
    <#--                </form>-->
</div>
</div>
<!-- /.col-lg-3 -->