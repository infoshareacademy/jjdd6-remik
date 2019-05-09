<link href="/static/css/ChannelMenuWithFavorites.css" rel="stylesheet">

<h3 class="my-4">Lista kanałów</h3>
<div class="list-group">
    <#--                <form method="post" onsubmit="/programme/fav">-->

    <#list channels as channel>
        <div class="list-group-item">
            <button  class="favbutton" onclick="this.blur(); favorites('${channel!}')">☆</button><a href="/programme/new?ch=${channel?url}">${channel!}</a>
        </div>
    </#list>
    <#--                style="font-size: 12px"-->
    <#--                </form>-->
</div>
</div>
<!-- /.col-lg-3 -->