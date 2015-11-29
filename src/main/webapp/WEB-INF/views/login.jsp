<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="jdiClient">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="/assets/bower_components/components-font-awesome/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="/assets/css/wallet.css">
    </head>
    <body>
        <div class="content main-box" ng-controller="AccessController as accessCtrl">
            <div class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 pull-right">
                <div class="row">
                    <form:form name="signup"  method="post" action="/login" modelAttribute="user" class="form-signin mg-btm" ng-submit="signup.$valid && signin(newUser)">
                        <h3 class="heading-desc">
                            Facilite suas compras e ganhe muitas vantagens
                            </h3>
                            <div class="social-box">
                            <div class="row mg-btm">
                                <div class="col-md-12">
                                    <a href="#" class="btn btn-primary btn-block">
                                        <i class="icon-facebook"></i>Entre com Facebook
                                    </a>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <a href="#" class="btn btn-info btn-block" >
                                        <i class="icon-twitter"></i>Entre com Twitter
                                    </a>
                                </div>
                                <div class="col-lg-2 col-lg-offset-5
                               conditional-label col-xs-4 col-xs-offset-4">
                                    OU
                                </div>
                            </div>
                        </div>
                        <div class="main">
                            <div class="col-md-6 col-md-offset-2">
                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger">
                                        Invalid UserName and Password.
                                    </div>
                                </c:if>
                                <c:if test="${param.logout != null}">
                                    <div class="alert alert-success">
                                        You have been logged out.
                                    </div>
                                </c:if>
                            </div>
                            <div class="form-group"
                                 ng-class="{'has-error': signup.username.$touched && signup.username.$invalid} ">
                                <div class="help-block" ng-messages="signup.username.$error" ng-if="signup.login.$touched">
                                    <p ng-message="required">Email é requerido</p>
                                    <p ng-message="username">Voc&ecirc;e precisa informar um username v&aacute;lido</p>
                                    <p ng-message="minlength">O username precisa ter no mínimo 5 caracteres</p>
                                </div>
                                <input id="username" type="username" name="username" required ng-minlength="5"  ng-model="newUser.email"
                                       class="form-control" placeholder="Seu username" autofocus>
                            </div>
                            <div class="form-group"
                                 ng-class="{'has-error': signup.password.$touched && signup.password.$invalid}">
                                <div class="help-block" ng-messages="signup.password.$error"
                                     ng-if="signup.password.$touched">
                                    Ainda nao se cadastrou ? <a href=""> inicie aqui</a>             <p ng-message="required">Voc&ecirc; precisa informar sua senha</p>
                                    <p ng-message="minlength">Sua senha precisa de 5 caracteres ou mais</p>
                                </div>
                                <input id="password" type="password" name="password" required ng-minlength="5" ng-model="newUser.password"
                                       class="form-control" placeholder="Senha letras e numeros">


                            <span class="clearfix"></span>
                            </div>
                        </div>
                        <div class="login-footer">
                            <div class="row">
                                <div class="col-xs-6 col-md-6">
                                    <div class="left-section">
                                        <a href="">Esqueceu sua senha</a>
                                        <a href="">Acesso</a>
                                    </div>
                                </div>
                                <div class="col-xs-6 col-md-6 pull-right">
                                    <button type="submit" class="btn btn-large btn-danger pull-right">Login</button>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
    <script src="<c:url value="/assets/bower_components/jquery/dist/jquery.min.js"/>"></script>
    <script src="<c:url value="/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/assets/bower_components/angular/angular.min.js"/>"></script>
    <script src="<c:url value="/assets/bower_components/angular-messages/angular-messages.min.js"/>"></script>
    <script src="<c:url value="/assets/bower_components/angular-ui-router/release/angular-ui-router.min.js"/>"></script>
    <script src="<c:url value="/assets/bower_components/angular-ui-mask/dist/mask.min.js"/>"></script>
    <script src="<c:url value="/assets/bower_components/angular-animate/angular-animate.min.js"/>"></script>
    <script src="<c:url value="/assets/bower_components/angular-resource/angular-resource.min.js"/>"></script>

    <script src="/assets/js/mall_wallet.js"></script>
    <script src="/assets/js/controllers/access_controller.js"></script>
    <script src="/assets/js/services/user.js"></script>
</html>