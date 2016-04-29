'use strict';

angular.module('app')
    .factory('Principal', function ($http, $location) {
        var principal = {
            isAuthenticated : false,
            authenticate: authenticate,
            logout: logout,
            name: undefined,
            authorities: []
        };

        return principal;

        function authenticate() {
            $http.get('user').then(function(response) {
                // response tels us about user
                principal.isAuthenticated = !!response.data.name;
                principal.name = response.data.name;
                principal.authorities = response.data.authorities;
            }, function() { // error when accessing user resource
                principal.isAuthenticated = false;
            });
        }

        function logout() {
            $http.post('logout', {}).finally(function() {
                principal.isAuthenticated = false;
                $location.path("/"); // go back to home page
            });
        }
    });