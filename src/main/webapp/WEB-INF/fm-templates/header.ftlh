<#setting url_escaping_charset='utf-8'>
<script src="/static/js/searchMenuNavBar.js"></script>
<script src="/static/js/returnTopButton.js"></script>
<button onclick="topFunction()" id="myBtn" class="myBtn" title="Go to top">Top</button>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <span class="container">
        <#--        <a class="navbar-brand" href="/">Start</a>-->
        <#--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"-->
        <#--                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">-->
        <#--            <span class="navbar-toggler-icon"></span>-->
        <#--        </button>-->


        <div class="form-inline">
            <div class="form-group nav-item active">

            <ul class="navbar-nav ml-auto">
                <li>

                <input type="text" class="nav-item active" name="tvItem" id="searchInputField"
                       placeholder="szukaj programu lub filmu">
                </li>

                    <li class="nav-item">
                        <button class="btn btn-default nav-link" onclick="this.blur(); searchTv()" name="mS" id="mS">
                            mS
                        </button>
                    </li>
                    <li class="nav-item">
                        <button class="btn btn-default nav-link" onclick="this.blur(); searchFilmweb()" id="FW">FW
                        </button>

                    </li>
                </ul>
            </div>
        </div>


        <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/">Home</a>
                        <span class="sr-only">(current)</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/programme/stats">Statystyki</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Kuku :)</a>
                    </li>
                    <li class="nav-item">
                        <div class="g-signin2" data-onsuccess="onSignIn"></div>
<#--                        <a class="nav-link" href="/movieSpotter/login">Sign In</a>-->
                    </li>
                </ul>
            </div>
        </span>
</nav>
