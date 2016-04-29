'use strict';

angular.module('app', [
    'ngRoute',
    'ui.router'
])
    .config(function ($httpProvider) {
        $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
    })
    .run(function (Principal) {
        Principal.authenticate();
    });