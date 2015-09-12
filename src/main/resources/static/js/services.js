

var services = angular.module('catalogApp.services', ['ngResource']);

services.factory('booksService',['$http',function($http){
        return {
            getBooks: function(){
                return $http.get('getBooks');
            }
            //,
            //getBooksOfAuthor:function(id){
            //    return $http.get('getBooksOfAuthor/'+id);
            //}
        }
    }]);


services.factory('authorsService',['$http',function($http){
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
            },
            deleteAuthor:function(id){
                return $http.post('deleteAuthor', id).
                    then(function(response){
                        return response;
                    })
            }
        }
    }]);

services.factory('loginService', ['$resource', function($resource){

        console.log("In loginService");

        return $resource(':action',{},{
            authenticate: {
                method: 'POST',
                params: {'action' : 'authenticate'},
                headers : {'Content-Type': 'application/x-www-form-urlencoded'}
            }
        });
    }]);

