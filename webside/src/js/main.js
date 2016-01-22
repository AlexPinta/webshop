var application = angular.module('application', ['ngRoute']);

account.service('account_service', function ($http, $rootScope) {
    return {
        getSoldados: function (resource) {
            return $http.get($rootScope.server_url + "/hi?format=json", {});
        }
    };
});

application.controller("account", function($rootScope, $scope, $http){
    $scope.main = {
        authentication: function(){
            $http.get($rootScope.server_url + resource);
        }
    };
})









application.run(function($rootScope){
    $rootScope.server_url = 'http://127.0.0.1:8080';
})
