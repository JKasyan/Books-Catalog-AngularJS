

angular.module('catalogApp',['ngRoute']).
    config(function($routeProvider){

        $routeProvider.when('/books.html',{
            templateUrl:'views/books.html',
            controller: 'booksController as bCtrl',
        }).


            when('/authors.html',{
            templateUrl:'views/authors.html',
            controller: 'authorsController as aCtrl',
        }).


            when('/books_of_author/:id.html',{
            templateUrl:'views/books.html',
            controller: 'booksOfAuthorController as bOfACtrl',
        }).


            when('/create_author.html',{
            templateUrl:'views/create_author.html',
            controller: 'newAuthorCtrl as nACtrl',
        }).

            when('/login.html', {
                templateUrl: 'views/login.html',
                controller: 'loginCtrl as lCtrl',
            });

        $routeProvider.otherwise({
            redirectTo:'/'
        });


         //$routeProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

    });
