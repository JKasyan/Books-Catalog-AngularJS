

var services = angular.module('catalogApp.services', ['ngResource']);

services.factory('booksService',['$http',function($http){
        return {
            getBooks: function(){
                return $http.get('getBooks');
            }
            ,
            getBooksOfAuthor:function(idAuthor){
                return $http.get('getBooksOfAuthor/'+idAuthor);
            }
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
            return $http.post('newBook',newBook).
                then(function(response){
                    return response;
                });
        }
    }
}]);

//http://www.meteoprog.ua/ru/api/city/Svitlovodsk/
services.factory("weatherService", ["$http", function($http){
    //return $resource(':action', {}, {
    //    getWeather: {
    //        method: "GET",
    //        params: {'action': '/ru/api/city/Kyiv/'},
    //        headers: {
    //            'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    //            'Accept-Charset': 'UTF-8,*;q=0.5',
    //            'Accept-Encoding': 'gzip,deflate,sdch',
    //            'Accept-Language': 'ru,en;q=0.8',
    //            'Cache-Control': 'max-age=0',
    //            'Connection': 'keep-alive',
    //            'Token': 'b9b3e3d337d48a25debfc42f36ba83dab19b7c89',
    //            'Host': 'www.meteoprog.ua',
    //            'User-Agent': 'Wget/1.12'
    //        }
    //    }
    //});
    return {
        getWeather: function() {
            return $http({
                method: 'GET',
                url: 'http://www.meteoprog.ua/ru/api/city/Kyiv/',
                headers: {
                    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
                    'Accept-Charset': 'UTF-8,*;q=0.5',
                    'Accept-Encoding': 'gzip,deflate,sdch',
                    'Accept-Language': 'ru,en;q=0.8',
                    'Cache-Control': 'max-age=0',
                    'Connection': 'keep-alive',
                    'Token': 'b9b3e3d337d48a25debfc42f36ba83dab19b7c89',
                    'Host': 'www.meteoprog.ua',
                    'User-Agent': 'Wget/1.12'
                }
            })
        }
    }
}])

