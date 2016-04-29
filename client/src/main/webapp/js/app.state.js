'use strict';

angular.module('app')
    .config(function ($stateProvider) {

        $stateProvider.state('default', {
            url: "",
            templateUrl: 'home.html',
            //controller: 'HomeController',
            //controllerAs: 'homeController',
            resolve: {
                authorize: ['Principal',
                    function (Principal) {
                        return Principal.isAuthenticated
                    }
                ]
            }
        })

    });