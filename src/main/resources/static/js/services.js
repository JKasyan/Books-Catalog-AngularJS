/**
 * Created by Evgen on 09.08.2015.
 */

angular.module('catalogApp').
    factory('booksService',['$http',function($http){
        return {
            getBooks: function(){
                return $http.get('getBooks');
            }
        }
    }]).factory('authorsService',['$http',function($http){
        return {
            getAuthors: function(){
                return $http.get('getAuthors');
            }
        }
    }]);