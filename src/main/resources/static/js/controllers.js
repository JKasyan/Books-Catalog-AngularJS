angular.module('catalogApp').

    controller('booksController', ['booksService', function (booksService) {
        var self = this;
        self.books = [];
        booksService.getBooks().then(function (response) {
            self.books = response.data;
        });
    }])


    .controller('authorsController', ['authorsService', function (authorsService) {
        var self = this;
        self.authors = [];
        authorsService.getAuthors().then(function (response) {
            self.authors = response.data;
        })

        self.deleteAuthor = function(authorId){
            authorsService.deleteAuthor(authorId).then(
                function(success){
                    var index = -1;
                    var array = eval(self.authors);
                    console.log('Eval: ', array, 'size: ', array.length);
                    console.log('authorId: ', authorId);
                    for(var i = 0;i<array.length;i++){
                        console.log("Id: ",array[i].id, ", typeOf: ", typeof(array[i].id));
                        if(array[i].id === authorId){
                            index = i;
                            break;
                        }
                    }
                    console.log('index: ', index);
                    if(index === -1){
                        console.log("Error!")
                    }
                    self.authors.splice(index, 1);
                },
                function(error){})
        }

        self.modifyAuthor = function(authorId){}
    }])


    .controller('newAuthorCtrl', ['authorsService', '$location', function (authorsService, $location) {
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
        self.selectedAuthors = [];

        authorsService.getAuthors().then(function (response) {
            self.authors = response.data;
            console.log('Fetched authors: ', self.authors);
        });

        self.newBook = {
            title:'',
            shortDescription:'',
            datePublish:'',
            authors:[]
        }

        self.createBook = function(){
            console.log('Selected authors: ', self.selectedAuthors);
            console.log('New book: ', self.newBook);
            //newBookService.createBook(self.newBook).then(function (success) {
            //    $location.path('/books');
            //}, function (error) {
            //
            //});
        };
    }])

    .controller("weatherController", ["weatherService", function(weatherService){
        var self = this;
        self.weatherData = {};
        weatherService.getWeather().then(function(response){
            console.log(response);
            self.weatherData = response.data;
            console.log('Fetched weather data: ', self.weatherData);
        })
    }])

