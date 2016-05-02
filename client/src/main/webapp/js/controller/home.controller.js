'use strict';

angular.module('app')
    .controller('HomeController', function ($scope, DemoService) {
        var vm = this;
        vm.response = "";

        init();

        function init() {
            DemoService.getHelloWorld().then(function(data) {
                vm.response = data.message;
            });
        }

        return vm;
    });