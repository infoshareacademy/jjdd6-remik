

function searchTv() {

    var programme2search = document.getElementById("searchInputField").value;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/programme/find", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xhr.send('tvItem=' + programme2search);
}

function searchFilmweb() {

    var movieSearch = document.getElementById("searchInputField").value;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/programme/details", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xhr.send('title=' + movieSearch);
}
