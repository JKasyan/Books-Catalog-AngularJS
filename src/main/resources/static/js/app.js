/**
 * Created by Evgen on 09.08.2015.
 */

angular.module('catalogApp',['ngRoute']).
    config(function($routeProvider){

        $routeProvider.when('/books.html',{
            templateUrl:'views/books.html',
            controller: 'booksController as bCtrl',
        }).when('/authors.html',{
            templateUrl:'views/authors.html',
            controller: 'authorsController as aCtrl',
        });

        $routeProvider.otherwise({
            redirectTo:'/'
        });
    });
