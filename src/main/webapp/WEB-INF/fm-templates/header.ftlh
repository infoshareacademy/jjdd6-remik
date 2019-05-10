<#setting url_escaping_charset='utf-8'>
<script src="/static/js/searchMenuNavBar.js"></script>
<script src="/static/js/returnTopButton.js"></script>
<button onclick="topFunction()" id="myBtn" class="myBtn" title="Go to top">Top</button>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
<#--        <a class="navbar-brand" href="/">Start</a>-->
<#--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"-->
<#--                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">-->
<#--            <span class="navbar-toggler-icon"></span>-->
<#--        </button>-->

        <form class="form-inline">
            <div class="form-group nav-item active">

                <input type="text" class="nav-item active" name="tvItem" id="searchInputField" placeholder="szukaj programu lub filmu">
            </div>
            <div>
                <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <button class="btn btn-default nav-link" onclick="this.blur(); searchTv()" name="mS" id="mS">mS</button>
                </li>
                <li class="nav-item">
                    <button class="btn btn-default nav-link" onclick="this.blur(); searchFilmweb()" name="FW" id="FW">FW</button>
                </li>
                </ul>
            </div>
            <div>
<#--            <input type="submit" class="btn btn-default nav-item active" value="mS" onclick="searchTv()"/>-->

            </div>
        </form>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                  <li class="nav-item active">
                        <a class="nav-link" href="#">Home</a>
                        <span class="sr-only">(current)</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
            </ul>
        </div>
    </div>
</nav>
