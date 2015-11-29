(function(){
    'use strict';

    angular.module('jdiClient')
     .controller('AccessController' ,['$scope','$resource','UserService', function($scope, $resource, UserService){
         $scope.user = {};
         $scope.tt = 'fdf';

         $scope.signin = function(user){
             UserService.save({email: user.email, senha: user.senha})
             $promise.then(function(){

             },function(){

             });
         };

    }]);
})();