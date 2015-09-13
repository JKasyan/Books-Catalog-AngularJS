
angular.module('catalogApp', ['ngRoute', 'ngCookies', 'securityModule', 'catalogApp.services']).
    config(['$routeProvider', '$httpProvider',
        function ($routeProvider) {

            $routeProvider.when('/books', {
                templateUrl: 'views/books.html',
                controller: 'booksController as bCtrl',
            }).


                when('/authors', {
                    templateUrl: 'views/authors.html',
                    controller: 'authorsController as aCtrl',
                }).


                when('/books_of_author/:id', {
                    templateUrl: 'views/books.html',
                    controller: 'booksOfAuthorController as bOfACtrl',
                }).


                when('/create_author', {
                    templateUrl: 'views/create_author.html',
                    controller: 'newAuthorCtrl as nACtrl',
                }).

                when('/login', {
                    templateUrl: 'views/login.html',
                    controller: 'loginCtrl as lCtrl',
                }).

                when('/create_book', {
                    templateUrl: 'views/create_book.html',
                    controller: 'newBookController'
                });

            $routeProvider.otherwise({
                redirectTo: '/'
            });

        }]);
