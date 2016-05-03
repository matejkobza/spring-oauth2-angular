'use strict';

angular.module('app')
    .factory('DemoService', function ($http) {
        return {
            getHelloWorld: getHelloWorld,
            getAuthorizedCall: getAuthorizedCall
        };

        function getHelloWorld() {
            return $http.get("api/test").then(function (response) {
                return response.data;
            });
        }

        function getAuthorizedCall() {
            return $http.get("api/withPermission").then(function (response) {
                return response.data;
            })
        }
    });