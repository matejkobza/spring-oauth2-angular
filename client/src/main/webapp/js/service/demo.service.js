'use strict';

angular.module('app')
    .factory('DemoService', function ($http) {
        return {
            getHelloWorld: getHelloWorld
        };

        function getHelloWorld() {
            return $http.get("api/test").then(function (response) {
                return response.data;
            });
        }
    });