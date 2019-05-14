
function favorites(a) {

    var menuItem = document.getElementById(a);

    if (menuItem.innerText == "☆") {
        menuItem.innerText = "★"
    } else {
        menuItem.innerText = "☆"
    }

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/programme/favorites", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
    xhr.send('favchan=' + a);
}