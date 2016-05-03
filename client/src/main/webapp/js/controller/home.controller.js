'use strict';

angular.module('app')
    .controller('HomeController', function ($scope, DemoService) {
        var vm = this;
        vm.response = "";
        vm.authorizedMessage = "";

        init();

        function init() {
            DemoService.getHelloWorld().then(function(data) {
                vm.response = data.message;
            });

            DemoService.getAuthorizedCall().then(function(data) {
               vm.authorizedMessage = data.message;
            });
        }

        return vm;
    });