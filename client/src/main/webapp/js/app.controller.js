'use strict';

angular.module('app')
    .controller('AppController', function ($scope, Principal, $rootScope) {
        var vm = this;

        $rootScope.Principal = Principal;

        return vm;
    });