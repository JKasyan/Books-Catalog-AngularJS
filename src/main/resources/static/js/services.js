

var services = angular.module('catalogApp.services', ['ngResource']);

services.factory('booksService',['$http',function($http){
        return {
            getBooks: function(){
                return $http.get('api/getBooks');
            }
            ,
            getBooksOfAuthor:function(idAuthor){
                return $http.get('api/getBooksOfAuthor?idAuthor='+idAuthor);
            }
        }
    }]);


services.factory('authorsService',['$http',function($http){
        return {
            getAuthors: function(){
                return $http.get('api/getAuthors');
            },
            addAuthor:function(author){
                console.log('authorsService: ',author);
                return $http.post('api/addAuthor',author).
                    then(function(response){
                    return response;
                });
            },
            deleteAuthor:function(id){
                return $http.post('api/deleteAuthor', id).
                    then(function(response){
                        return response;
                    })
            },
            getAuthor: function(idAuthor){
                return $http.get('api/getAuthor?idAuthor='+idAuthor);
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
            return $http.post('api/addBook',newBook).
                then(function(response){
                    return response;
                });
        }
    }
}]);

