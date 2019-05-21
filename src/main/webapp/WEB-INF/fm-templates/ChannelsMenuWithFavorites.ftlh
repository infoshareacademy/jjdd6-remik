<link href="/static/css/ChannelMenuWithFavorites.css" rel="stylesheet">
<script src="/static/js/favorites.js"></script>

<h3 class="my-4">Lista kanałów</h3>
<div class="list-group">

    <#if usersFavorites??>
    <#attempt>
        <#assign x = usersFavorites>
        <#recover>
    </#attempt>
    </#if>


    <#list channels as channel>
        <div class="list-group-item">
            <#if x??>
                <#attempt>
                    <button class="favbutton" id="${channel.id!}"
                            onclick="favorites('${channel.id!}')">${x?seq_contains(channel.id)?string("★","☆")}</button>
                    <#recover>
                </#attempt>
            </#if>
            <a href="/programme/new?ch=${channel.name?url}">${channel.name!}</a>
        </div>
    </#list>
</div>
</div>
