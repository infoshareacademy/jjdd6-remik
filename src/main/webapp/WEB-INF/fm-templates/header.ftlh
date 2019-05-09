<#setting url_escaping_charset='utf-8'>

<script src="/static/js/returnTopButton.js"></script>
<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
<#--        <a class="navbar-brand" href="/">Start</a>-->
<#--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"-->
<#--                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">-->
<#--            <span class="navbar-toggler-icon"></span>-->
<#--        </button>-->

        <form class="form-inline">
            <div class="form-group mb-2">

                <input type="text" class="form-control-plaintext" id="searchInputField" value="szukaj programu lub filmu">
            </div>
            <div>&nbsp;</div>
            <div>
            <button type="submit" class="btn btn-warning mb-2" onclick="searchTv()">szukaj programu</button>
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
<script>

    function searchTv() {

        var programme2search = document.getElementById("searchInputField").value

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/programme/find", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        xhr.send('tvItem=' + programme2search);
    }

</script>