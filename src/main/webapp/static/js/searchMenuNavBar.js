

function searchTv() {

    var programme2search = document.getElementById("searchInputField").value;
    var full = "/programme/find?tvItem="+programme2search;

    window.location.assign(full);

}

function searchFilmweb() {

    //var full = location.protocol+'//'+location.hostname+(location.port ? ':'+location.port: '')+"/programme/details";

    var movieSearch = document.getElementById("searchInputField").value;
    var full = "/programme/details?title="+movieSearch;

    window.location.assign(full);


}
