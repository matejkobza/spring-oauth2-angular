'use strict';
angular.module('app', [
    'ui.router',
    'ngRoute'
]).config(function ($stateProvider, $urlRouterProvider, $httpProvider) {

        $urlRouterProvider.otherwise("/");

        $stateProvider
            .state('home', {
                templateUrl: 'home.html',
                controller: 'home',
                controllerAs: 'controller'
            });

        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

    })
    .run(function () {

    });

angular.module('app')
    .controller('navigation',

        function ($rootScope, $http, $location, $route) {

            var self = this;

            self.tab = function (route) {
                return $route.current && route === $route.current.controller;
            };

            $http.get('user').then(function (response) {
                if (response.data.name) {
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
            }, function () {
                $rootScope.authenticated = false;
            });

            self.credentials = {};

            self.logout = function () {
                $http.post('logout', {}).finally(function () {
                    $rootScope.authenticated = false;
                    $location.path("/");
                });
            }

        });

angular.module('app')
    .controller('home', function ($http) {

        var self = this;

        $http.get('resource/').then(function (response) {
            self.greeting = response.data;
        })
    });
