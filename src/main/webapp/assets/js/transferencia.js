(function($, globals){

    $('#transferencia-box').submit(function(form){
        form.preventDefault();

        $.ajax({
            method: 'GET',
            url: '/cliente/busca?celular='+$('#phone').val()
        }).then(function(userResponse){
            if(userResponse){
                $('#user-data').show();
            }else{
                $('#error-message').html('voce realmente esta cadastrado? verifique seu celular ;)').show();
            }
        }, function(errorResponse){
            console.log(errorResponse);
            if(errorResponse){
              $('#error-message').html('Falha ao encontrar seu usuario').show();
            }
        });
    });
})(jQuery, window);
