
var xAuthTokenHeaderName = 'x-auth-token';

angular.module('catalogApp', ['ngRoute', 'ngCookies','catalogApp.services']).
    config(['$routeProvider', '$httpProvider',
        function ($routeProvider, $httpProvider) {

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
                });

            $routeProvider.otherwise({
                redirectTo: '/'
            });

            var interceptor = function ($rootScope, $q, $location) {

                console.log("In interceptor");

                function success(response) {
                    console.log("Success response");
                    return response;
                }

                function error(response) {
                    console.log("Error response");
                    var status = response.status;
                    var config = response.config;
                    var method = config.method;
                    var url = config.url;

                    if (status == 401) {
                        console.log('401 Unauthorized: ', status);
                        $location.path("/login");
                    } else {
                        $rootScope.error = method + " on " + url + " failed with status " + status;
                    }
                    return $q.reject(response);
                }

                return function (promise) {
                    console.log('promise: ', promise);
                    return promise.then(success, error);
                }
            };

            $httpProvider.responseInterceptors.push(interceptor);

        }]).run(function($rootScope, $http, $location, $cookieStore) {

        /* Reset error when a new view is loaded */
        $rootScope.$on('$viewContentLoaded', function() {
            delete $rootScope.error;
        });

        $rootScope.hasRole = function(role) {

            if ($rootScope.user === undefined) {
                return false;
            }

            if ($rootScope.user.roles[role] === undefined) {
                return false;
            }

            return $rootScope.user.roles[role];
        };

        $rootScope.logout = function() {
            delete $rootScope.user;
            delete $http.defaults.headers.common[xAuthTokenHeaderName];
            $cookieStore.remove('user');
            $location.path("/login");
        };

        /* Try getting valid user from cookie or go to login page */
        var originalPath = $location.path();
        $location.path("/login");
        var user = $cookieStore.get('user');
        if (user !== undefined) {
            $rootScope.user = user;
            $http.defaults.headers.common[xAuthTokenHeaderName] = user.token;

            $location.path(originalPath);
        };
    });

function booksController(booksService){
    var self = this;
    self.books = [];
    booksService.getBooks().then(function (response) {
        self.books = response.data;
        console.log('Fetch book: ', self.books);
    });
}

function authorsController(authorsService){
    var self = this;
    self.authors = [];
    authorsService.getAuthors().then(function (response) {
        self.authors = response.data;
    });
}

function newAuthorCtrl(authorsService, $location){
    var self = this;
    self.author = {
        name:"",
        secondName:"",
        books:[]
    };
    self.createAuthor = function(){
        console.log('New author: ', self.author);
        authorsService.addAuthor(self.author).then(function(success){
            $location.path('/authors.html');
        }, function(error){
            console.log("Error: ", error);
            self.errorMsg = error.data.msg;
        });
    };
}

function loginCtrl($scope, $rootScope, $location, $http, $cookieStore, loginService){
    $scope.login = function() {
        console.log("In loginCtrl");
        loginService.authenticate($.param({username: $scope.username, password: $scope.password}), function(user) {
            console.log("user: ", user);
            $rootScope.user = user;
            $http.defaults.headers.common[ xAuthTokenHeaderName ] = user.token;
            $cookieStore.put('user', user);
            $location.path("/");
        });
    };
}


var services = angular.module('catalogApp.services', ['ngResource']);

services.factory('loginService', function($resource){
    console.log('In loginService...');
    return $resource(':action', {},
        {
            authenticate: {
                method: 'POST',
                params: {'action' : 'authenticate'},
                headers : {'Content-Type': 'application/x-www-form-urlencoded'}
            }
        }
    );
});

services.factory('booksService', function($http){
    return {
        getBooks: function(){
            return $http.get('getBooks');
        }
    }
});

services.factory('authorsService', function($http){
    return {
        getAuthors: function(){
            return $http.get('getAuthors');
        },
        addAuthor:function(author){
            console.log('authorsService: ',author);
            return $http.post('addAuthor',author).
                then(function(response){
                    return response;
                });
        }
    }
});
