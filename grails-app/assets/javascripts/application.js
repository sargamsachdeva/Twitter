// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require prototype
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

function callAjax() {
    $(document).ready(function () {
        $('.text-button').click(function() {
                //var id=$(this).attr('data-id');
                var url = "${createLink(controller: 'tweet',action:'index')}";
                $.ajax({
                    type: 'POST',
                    url: url,
                    success: function (data) {
                        console.log(data);
                        $('#count').alert="wdwdwd";
                    }
                });
        })
    })
}
