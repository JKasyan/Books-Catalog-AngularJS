angular.module('catalogApp').

    controller('booksController', ['booksService', function (booksService) {
        var self = this;
        self.books = [];
        booksService.getBooks().then(function (response) {
            self.books = response.data;
        });

        self.deleteBook = function(idBook) {
            console.log('IdBook ', idBook);
            booksService.deleteBook(idBook).then(

                function(success) {
                    console.log(success);
                    var index;
                    for(var i=0;i<self.books.length;i++){
                        console.log('i: ', i,
                            self.books[i]["idBook"] == idBook);
                        if(self.books[i]["idBook"] == idBook){
                            index = self.books.indexOf(self.books[i]);
                            console.log("index: ", index);
                            self.books.splice(index, 1);
                            break;
                        }
                    }

                },

                function(error) {
                    console.log("Error: ", error)
                }
            )
        }
    }])


    .controller('authorsController', ['authorsService', function (authorsService) {
        var self = this;
        self.authors = [];
        authorsService.getAuthors().then(function (response) {
            self.authors = response.data;
            console.log(self.authors)
        });

        self.deleteAuthor = function(idAuthor){
            authorsService.deleteAuthor(idAuthor).then(

                function(success) {
                    console.log(success);
                    console.log("idAuthor: ", idAuthor);
                    var index;
                    for(var i=0;i<self.authors.length;i++){
                        console.log('i: ', i,
                            self.authors[i]["idAuthor"] == idAuthor);
                        if(self.authors[i]["idAuthor"] == idAuthor){
                            index = self.authors.indexOf(self.authors[i]);
                            console.log("index: ", index);
                            self.authors.splice(index, 1);
                            break;
                        }
                    }

                },

                function(error) {
                    console.log("Error: ", error)
                }

            )}

        self.modifyAuthor = function(authorId){}
    }])


    .controller('newAuthorCtrl', ['authorsService', '$location', function (authorsService, $location) {
        var self = this;
        self.author = {
            firstName: "",
            secondName: ""
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
    }])


    .controller('loginCtrl', ['$scope', '$rootScope',
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
        }])

    .controller('newBookController',['newBookService','authorsService', '$location',
        function(newBookService, authorsService, $location){
        var self = this;
        self.authors = [];

        authorsService.getAuthors().then(function (response) {
            var authors = response.data;
            for(var i = 0; i< authors.length;i++) {
                var fullName = authors[i]["firstName"] + " " +  authors[i]["secondName"];
                self.authors[i] = {
                    "fullName": fullName,
                    "idAuthor": authors[i]["idAuthor"]
                }
            }
            console.log("Authors: ", self.authors)
        });

        self.newBook = {
            title:'',
            shortDescription:'',
            datePublish:'',
            authors:[]
        };

        self.createBook = function(){
            console.log('New book: ', self.newBook);
            newBookService.createBook(self.newBook).then(
                function (success) {
                $location.path('/books');
            }, function (error) {
                console.log('Error!!!');
            });
        };
    }])

    .controller("booksOfAuthorController", ["$routeParams", "booksService", function($routeParams, booksService){
        var self = this;
        self.books = [];
        var idAuthor = $routeParams.id;
        console.log($routeParams);
        console.log("idAuthor: ", idAuthor);
        booksService.getBooksOfAuthor(idAuthor).then(function(response){
            self.books = response.data;
            console.log(self.books);
        })
    }])

    .controller("modifyAuthorController", ["authorsService", "$routeParams", "$location", function(authorsService, $routeParams, $location){
        var self = this;
        var idAuthor = $routeParams.id;
        self.author = {};
        authorsService.getAuthor(idAuthor).then(function (response) {
            self.author = response.data;
            console.log(self.author)
        });

        self.modifyAuthor = function() {
            console.log(self.author);
            authorsService.updateAuthor(self.author).then(
                function(success){
                    $location.path('/authors');
                },
                function(error) {

                }
            )
        }
    }])

    .controller('modifyBookController', ['booksService', "authorsService", "$routeParams", "$location", "$scope",
        function(booksService, authorsService, $routeParams, $location, $scope){
            var id = $routeParams.id;
            $scope.book = {};
            var splitAuthors = [];
            /**
             *
             */
            booksService.getBookById(id).then(
                function(response){
                    var authors = response.data.authors;
                    splitAuthors = authors.map(function(author){
                        var split = author.split(",");
                        return {
                            "id":split[0]
                        }
                    });
                    $scope.book = response.data;
                    console.log($scope.book);
                }
            );
            /**
             *
             */
            $scope.allAuthors = [];
            authorsService.getAuthors().then(
                function(response) {
                    var authors = response.data;
                    $scope.allAuthors = authors.map(function(author){
                        return {
                            "id":author.idAuthor,
                            "fullName": author.firstName + " " + author.secondName,
                            "selected": false
                        };
                    });
                    for(var i = 0;i<splitAuthors.length;i++) {
                        for(var j = 0; j< $scope.allAuthors.length;j++){
                            if(splitAuthors[i].id == $scope.allAuthors[j].id) {
                                console.log($scope.allAuthors[j].fullName, " is selected")
                                $scope.allAuthors[j].selected = true;
                                break;
                            }
                        }
                    }
                    console.log("All: ",$scope.allAuthors);
                }
            );

            $scope.modifyBook = function(){
                var authors = [];
                $scope.allAuthors.forEach(function(author){
                    if(author.selected == true) {
                        authors.push(author.id)
                    }
                });
                $scope.book.authors = authors;
                console.log("Updating book: ", $scope.book);
                booksService.updateBook($scope.book).then(
                    function(success){
                        $location.path('/books');
                    },
                    function(error){
                    }
                )
            }
        }]);
