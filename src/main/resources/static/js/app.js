/**
 * Created by Evgen on 09.08.2015.
 */

angular.module('catalogApp',['ngRoute']).
    config(function($routeProvider){

        $routeProvider.when('/books',{
            templateUrl:'views/books.html',
            controller: 'booksController',
            controllerAs:'bCtrl'
        }).when('/authors',{
            templateUrl:'views/authors.html',
            controller: 'authorsController',
            controllerAs:'aCtrl'
        });

        $routeProvider.otherwise({
            redirectTo:'/'
        });
    });
