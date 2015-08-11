/**
 * Created by Evgen on 09.08.2015.
 */

angular.module('catalogApp').

    controller('booksController', ['booksService', function (booksService) {
        var self = this;
        self.books = [];
        booksService.getBooks().then(function (response) {
            console.log(response.data);
            self.books = response.data;
        });
    }]).

    controller('authorsController', ['authorsService', function (authorsService) {
        var self = this;
        self.authors = [];
        authorsService.getAuthors().then(function (response) {
            console.log(response.data);
            self.authors = response.data;
        });

    }]);