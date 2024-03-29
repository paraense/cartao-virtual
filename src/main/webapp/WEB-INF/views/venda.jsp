<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DigCard</title>

    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bower_components/bootstrap/dist/css/bootstrap.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/freelancer.css">

    <!-- Custom Fonts -->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bower_components/components-font-awesome/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet"
          type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">

<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#page-top">DigCard</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <%--<li class="page-scroll">--%>
                <%--<a href="#portfolio">Historico</a>--%>
                <%--</li>--%>
                <li class="page-scroll">
                    <a href="#recarga-modal" class="portfolio-link" data-toggle="modal">Vender</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<!-- Header -->
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <img class="img-responsive" src="/styles/img/user.png" alt="">

                <div class="intro-text">
                    <span class="name"> ${loja.nome}</span>
                    <hr class="star-light">
                    <span class="skills"></span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Portfolio Grid Section -->
<section id="portfolio">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <i class="fa fa-2x fa-book"></i>

                <h2>Últimas transações</h2>
                <hr class="star-primary">


            </div>
        </div>
        <div class="row">
        </div>
    </div>
</section>

<!-- About Section -->
<!-- Footer -->
<footer class="text-center">
    <div class="footer-above">
        <div class="container">
            <div class="row">
                <div class="footer-col col-md-4">
                    <h3>Endereco</h3>

                    <p>Av. Bl-10<br>Proximo ao boulevard</p>
                </div>
                <div class="footer-col col-md-4">
                    <h3>Nos na rede</h3>
                    <ul class="list-inline">
                        <li>
                            <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-google-plus"></i></a>
                        </li>
                        <li>
                            <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-linkedin"></i></a>
                        </li>
                        <li>
                            <a href="#" class="btn-social btn-outline"><i class="fa fa-fw fa-dribbble"></i></a>
                        </li>
                    </ul>
                </div>
                <div class="footer-col col-md-4">
                    <i class="fa fa-3x fa-lightbulb-o"></i>

                    <h3>Sobre essa ideia</h3>

                    <p>Estamos tentando aproximar o cliente do varejista de uma forma bem legal ;)</p>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-below">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    Copyright &copy; Your Website 2014
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div class="scroll-top page-scroll visible-xs visible-sm">
    <a class="btn btn-primary" href="#page-top">
        <i class="fa fa-chevron-up"></i>
    </a>
</div>

<div class="portfolio-modal modal fade" id="portfolioModal4" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>Project Title</h2>
                        <hr class="star-primary">
                        <img src="img/portfolio/game.png" class="img-responsive img-centered" alt="">

                        <p>Use this area of the page to describe your project. The icon above is part of a free icon set
                            by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can
                            download their free set with 16 icons, or you can purchase the entire set with 146 icons for
                            only $12!</p>
                        <ul class="list-inline item-details">
                            <li>Client:
                                <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                </strong>
                            </li>
                            <li>Date:
                                <strong><a href="http://startbootstrap.com">April 2014</a>
                                </strong>
                            </li>
                            <li>Service:
                                <strong><a href="http://startbootstrap.com">Web Development</a>
                                </strong>
                            </li>
                        </ul>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i>
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal5" tabindex="-1" role="dialog" aria-hidden="true">
    fdsfsd
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2>Project Title</h2>
                        <hr class="star-primary">
                        <img src="img/portfolio/safe.png" class="img-responsive img-centered" alt="">

                        <p>Use this area of the page to describe your project. The icon above is part of a free icon set
                            by <a href="https://sellfy.com/p/8Q9P/jV3VZ/">Flat Icons</a>. On their website, you can
                            download their free set with 16 icons, or you can purchase the entire set with 146 icons for
                            only $12!</p>
                        <ul class="list-inline item-details">
                            <li>Client:
                                <strong><a href="http://startbootstrap.com">Start Bootstrap</a>
                                </strong>
                            </li>
                            <li>Date:
                                <strong><a href="http://startbootstrap.com">April 2014</a>
                                </strong>
                            </li>
                            <li>Service:
                                <strong><a href="http://startbootstrap.com">Web Development</a>
                                </strong>
                            </li>
                        </ul>
                        <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-times"></i>
                            Close
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="portfolio-modal modal fade" id="portfolioModal6" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
    </div>
</div>

<div class="portfolio-modal modal fade" id="recarga-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <form method="post" name="recarga" id="recarga-box" action="recarregar" novalidate>
                            <div class="row control-group">
                                <div class="form-group col-xs-12 floating-label-form-group controls">
                                    <label>Valor R$</label>
                                    <input type="text" name="valor" class="form-control"
                                           placeholder="Valor" id="valor">

                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group col-xs-12 floating-label-form-group controls">
                                    <label>CPF</label>
                                    <input type="text" name="valor" class="form-control"
                                           placeholder="CPF (Somente números)"
                                           id="cpf" onkeyup="cpf_keyup()">

                                    <p class="help-block text-danger" id="cpf_erro"></p>

                                    <p class="help-block text-info" id="cpf_achou"></p>
                                </div>
                            </div>
                            <br>

                            <div id="success"></div>
                            <div class="row">
                                <div class="form-group col-xs-12">
                                    <button class="btn btn-success btn-lg" id="btnEnvia">
                                        Efetuar venda
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="portfolio-modal modal fade" id="confirma-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" data-dismiss="modal">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <input type="hidden" id="codTransacao">

                        <div class="form-group col-xs-12 floating-label-form-group controls">
                            <label>Valor R$</label>
                            <input type="text" name="valor" class="form-control"
                                   placeholder="Código de confirmação" id="codigo">

                            <p class="help-block text-danger"></p>
                        </div>

                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button class="btn btn-success btn-lg" id="btnConfirma" onclick="confirma()">
                                    Confirmar
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="portfolio-modal modal fade" id="posConfirma-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <div class="close-modal" onclick="finaliza()">
            <div class="lr">
                <div class="rl">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="modal-body">
                        <h2 id="msgConfirma"></h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- jQuery -->
<script src="<c:url value="/styles/bower_components/jquery/dist/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/styles/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>

<!-- Plugin JavaScript -->
<script src="<c:url value="/styles/js/template/classie.js"/> "></script>
<script src="<c:url value="/styles/js/template/cbpAnimatedHeader.min.js"/> "></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="<c:url value="/styles/js/template/jqBootstrapValidation.js"/> "></script>
<script src="<c:url value="/styles/js/template/contact_me.js"/> "></script>
<script src="js/jqBootstrapValidation.js"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value="/styles/js/template/freelancer.js"/> "></script>

<script>
    function finaliza() {
        $('#recarga-modal').modal('hide');
        $('#confirma-modal').modal('hide');
        $('#posConfirma-modal').modal('hide');
    }

    function confirma() {
        $.ajax({
            url: "/loja/confirma",
            data: {idTransacao: $('#codTransacao').val(), codigo: $('#codigo').val()},
            method: 'POST'
        }).done(function (data) {
            if (data == 'ok') {
                $('#msgConfirma').html('Transação aceita');
            }
            else {
                $('#msgConfirma').html(data);
            }

            $('#posConfirma-modal').modal('toggle');
        });
    }

    (function () {
        $('#recarga-box').submit(function (form) {
            form.preventDefault();

            $.ajax({
                url: "/loja/venda",
                data: {valor: $('#valor').val(), cpf: $('#cpf').val()},
                method: 'POST'
            }).done(function (data) {
                $('#codTransacao').val(data);
                $('#confirma-modal').modal('toggle');
            });
        });
    })();

    function cpf_keyup() {
        $('#cpf_achou').html("");

        $.getJSON("/cliente/buscaCpf/" + $('#cpf').val(), function (data) {
            $('#cpf_achou').html(data.usuario.nome);
        });
    }

</script>

</body>

</html>
