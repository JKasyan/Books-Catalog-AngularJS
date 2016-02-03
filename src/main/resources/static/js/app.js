
angular.module('catalogApp', ['ngRoute', 'ngCookies', 'securityModule', 'catalogApp.services', 'checklist-model'])
    .config(['$routeProvider', '$httpProvider',
        function ($routeProvider) {

            $routeProvider
                .when('/books', {
                    templateUrl: 'views/books.html',
                    controller: 'booksController as bCtrl'
                })


                .when('/authors', {
                    templateUrl: 'views/authors.html',
                    controller: 'authorsController as aCtrl'
                })


                .when('/books_of_author/:id', {
                    templateUrl: 'views/books_of_author.html',
                    controller: 'booksOfAuthorController as bOfACtrl'
                })

                .when('/modify_author/:id', {
                    templateUrl: 'views/modify_author.html',
                    controller: 'modifyAuthorController as modACtrl'
                })

                .when('/modify_book/:id', {
                    templateUrl: 'views/modify_book.html',
                    controller: 'modifyBookController as modBCtrl'
                })

                .when('/create_author', {
                    templateUrl: 'views/create_author.html',
                    controller: 'newAuthorCtrl as nACtrl'
                })

                .when('/login', {
                    templateUrl: 'views/login.html',
                    controller: 'loginCtrl as lCtrl'
                })

                .when('/create_book', {
                    templateUrl: 'views/create_book.html',
                    controller: 'newBookController as nBCtrl'
                })

                .when('/chat', {
                    templateUrl: 'views/chat.html',
                    controller: 'messageCtrl'
                })

            $routeProvider.otherwise({
                redirectTo: '/'
            });
        }]);
