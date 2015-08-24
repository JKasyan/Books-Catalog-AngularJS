/**
 * Created by Evgen on 09.08.2015.
 */

angular.module('catalogApp').

    controller('booksController', ['booksService', function (booksService) {
        var self = this;
        self.books = [];
        booksService.getBooks().then(function (response) {
            self.books = response.data;
            for(var i = 0;i<self.books.length;i++){
                console.log('Book'+i,self.books[i]);
            }
        });
    }]).


    controller('authorsController', ['authorsService', function (authorsService) {
        var self = this;
        self.authors = [];
        authorsService.getAuthors().then(function (response) {
            self.authors = response.data;
            for(var i = 0;i<self.authors.length;i++){
                console.log('Author'+i,self.authors[i]);
            }
        })
    }]).


    controller('newAuthorCtrl', ['authorsService','$location', function(authorsService, $location){
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
                self.errorMsg = error.data.msg;
            });
        };
    }]).

    /*
    * Controller for authentication
     */
    controller('loginCtrl', ['$location', '$rootScope','$http', function($location, $rootScope, $http){

        var authenticate = function(credentials, callback){
            var headers = credentials?{authorization : "Basic "
            + btoa(credentials.username + ":" + credentials.password)}:{};

            $http.get('user', {headers: headers}).success(function(data){
                if(data.name){
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }).error(function(){
                $rootScope.authenticated = false;
                callback && callback();
            });
        }

        authenticate();

        var self = this;
        self.credentials = {};

        this.login = function(){
            authenticate(self.credentials, function(){
                if($rootScope.authenticated){
                    $location.path("/");
                    self.error = false;
                }else{
                    $location.path("/login.html");
                    self.error = false;
                }
            })
        };
    }]);