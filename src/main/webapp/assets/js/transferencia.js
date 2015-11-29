(function($, globals){

    $('#transferencia-box').submit(function(form){
        form.preventDefault();
        $.ajax({
            method: 'GET',
            url: '/cliente/busca',
            data: { celular: $('#phone').val() }
        }).done(function(userResponse){
            console.log(userResponse);

        }, function(errorReason){
            console.log(errorReason);
        });
    });
})(jQuery, window);