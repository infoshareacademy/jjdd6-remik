$(function () {

    $(document).ready(function () {

        $(".delete-user-link").click(function () {

            $.ajax({
                url: '/user?id=' + $(this).attr('data-id'),
                type: 'DELETE',
                success: function (result) {
                    location.reload();
                }
            });
        });
    });
});