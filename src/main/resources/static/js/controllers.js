/**
 * Created by Evgen on 09.08.2015.
 */

angular.module('catalogApp',[]).

    controller('booksController',['booksService',function(booksService){
        var self = this;
        self.books = [];
        booksService.getBooks().then(function(response){
            self.books = response.data;
        });
    }]).

    controller('authorsController',['booksService',function(authorsService){
        var self = this;
        self.authors = [];
        authorsService.getBooks().then(function(response){
            self.authors = response.data;
        });
    }]);