var app = angular.module('myApp', ['ngRoute','ngResource','localytics.directives', 'ui.bootstrap','AngularChart','ngMaterial']);

app.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl: '/views/tables.html',
            controller: 'tablesController'
        });
});


