angular.module('catalogApp').

    controller('booksController', ['booksService', function (booksService) {
        var self = this;
        self.books = [];
        booksService.getBooks().then(function (response) {
            self.books = response.data;
        });
    }]).


    controller('authorsController', ['authorsService', function (authorsService) {
        var self = this;
        self.authors = [];
        authorsService.getAuthors().then(function (response) {
            self.authors = response.data;
        })

        self.deleteAuthor = function(authorId){
            authorsService.deleteAuthor(authorId).then(
                function(success){
                    var authorForDelete = null;
                    for(var i = 0;i<self.authors.length;i++){
                        if(self.authors[i].id === authorId){
                            self.authors.slice(i);
                            break;
                        }
                    }
                    self.authors.remove(authorForDelete);
                },
                function(error){})
        }

        self.modifyAuthor = function(authorId){}
    }]).


    controller('newAuthorCtrl', ['authorsService', '$location', function (authorsService, $location) {
        var self = this;
        self.author = {
            name: "",
            secondName: "",
            books: []
        };
        self.createAuthor = function () {
            authorsService.addAuthor(self.author).then(function (success) {
                $location.path('/authors');
            }, function (error) {
                var errors = (error.data.fieldErrors != undefined) ? error.data.fieldErrors : [];
                for (var i = 0; i < errors.length; i++) {
                    var currentError = errors[i].message;
                    switch (errors[i].field) {
                        case "name":
                            $("#name_error").text(currentError);
                            break;
                        case "secondName":
                            $("#second_name_error").text(currentError);
                            break;
                    }
                }
            });
        };
    }]).


    controller('loginCtrl', ['$scope', '$rootScope',
        '$location', '$http', '$cookieStore', 'loginService',
        function ($scope, $rootScope, $location, $http, $cookieStore, loginService) {

            $scope.login = function () {
                loginService.authenticate($.param({username: $scope.username, password: $scope.password}),
                    function (user) {
                        $rootScope.user = user;
                        $http.defaults.headers.common[xAuthTokenHeaderName] = user.token;
                        $cookieStore.put('user', user);
                        $location.path("/authors");
                    });
            };
        }]);

//var someArray = [
//    {'id':1,'name':'Ivan'},
//    {'id':2,'name':'John'},
//    {'id':3,'name':'Robert'}
//];
//
//console.log(someArray);
//
//var objForDelete = someArray.filter(
//    function (el) {
//        return el.name === "John";
//    }
//)[0];
//
//someArray.remove(function(el) { return el.id === 1; });

