

var services = angular.module('catalogApp.services', ['ngResource']);

services.factory('booksService',['$http',function($http){
        return {
            getBooks: function(){
                return $http.get('api/books');
            },
            getBookById:function(id){
                return $http.get('api/books/' + id);
            }
            ,
            getBooksOfAuthor:function(idAuthor){
                return $http.get('api/books/authors/' + idAuthor);
            },

            deleteBook: function(idBook){
                console.log("deleteBook", idBook);
                return $http.delete('api/books/' + idBook)
                    .then(function(response){
                        return response;
                    })
            },
            updateBook: function(book) {
                console.log("updateBook", book);
                return $http.put("api/books", book);
            }
        }
    }]);


services.factory('authorsService',['$http',function($http){
        return {
            getAuthors: function(){
                return $http.get('api/authors');
            },
            addAuthor:function(author){
                return $http.post('api/authors',author).
                    then(function(response){
                    return response;
                });
            },
            deleteAuthor:function(id){
                return $http.delete('api/authors/' + id).
                    then(function(response){
                        return response;
                    })
            },
            getAuthor: function(idAuthor){
                return $http.get('api/authors/'+idAuthor);
            },
            updateAuthor: function(author){
                return $http.put('api/authors', author);
            }
        }
    }]);

services.factory('loginService', ['$resource', function($resource){
        return $resource(':action',{},{
            authenticate: {
                method: 'POST',
                params: {'action' : 'authenticate'},
                headers : {'Content-Type': 'application/x-www-form-urlencoded'}
            }
        });
    }]);

services.factory('newBookService', ['$http', function($http){
    return {
        createBook:function(newBook){
            return $http.post('api/books',newBook).
                then(function(response){
                    return response;
                });
        }
    }
}]);

services.factory('visitorService', ['$http', function($http){
    return {
        getVisitors:function() {
            return $http.get('api/visitors');
        }
    }
}]);
