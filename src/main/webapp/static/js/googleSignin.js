//google callback. This function will redirect to our login servlet

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    var redirectUrl = '/programme/account';

    //using jquery to post data dynamically
    var form = $('<form action="' + redirectUrl + '" method="post">' +
        '<input type="text" name="id_token" value="' +
        googleUser.getAuthResponse().id_token + '" />' +
        '</form>');
    $('body').append(form);
    form.submit();
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
        auth2.disconnect();
    });
    window.location.assign("/programme/account/logout");
}