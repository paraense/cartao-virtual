(function(){
    'use strict';

    angular.module('jdiClient')
        .factory('UserService', ['$resource', function($resource){
        return $resource('/login/:user',{user: '@user'});
   }]);
})();