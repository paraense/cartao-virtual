(function($, globals){
    $('#movement').hide();
    var client = {};

    $('#phone').keydown(function(e){
        $.ajax({
            method: 'GET',
            url: '/cliente/busca?celular='+$(this).val()

        }).done(function(userResponse){
            if(userResponse){
                $('#movement').show();
                $('#valor-transferencia').focus();
                client = userResponse;

            }else
                $('#error-message').html('Seu amigo esta cadastrado?, verifique novamente o numero de telefone').show();

        }).fail(function(errorResponse){
            if(errorResponse){
                $('#error-message').html('Falha ao encontrar seu usuario').show();
            }
        });
    });

    $('#transferencia-box').submit(function(form){
        form.preventDefault();
       var data = { destinatario: client, valor: $('#valor-trasferencia').val()};
            if(client && $('#valor-transferencia').val() ){
            $.ajax({
                url:'/cliente/transferir',
                method: 'POST',
                data: JSON.stringify(data)
            }).done(function(data){
                $('#transferencia-modal').modal('hide');
            }).fail(function(error){
                console.log( error);
            });
        }
    });
})(jQuery, window);
