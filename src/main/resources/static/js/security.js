/**
 * Created by Evgen on 27.08.2015.
 */

var xAuthTokenHeaderName = 'x-auth-token';

angular.module("catalogApp", ['ngRoute', 'ngCookies']).
    config(
    ['$routeProvider', '$locationProvider', '$httpProvider',
        function ($routeProvider, $locationProvider, $httpProvider) {

            var interceptor = function ($rootScope, $q, $location) {

                console.log("In interceptor");

                function success(response) {
                    console.log("Success response");
                    return response;
                }

                function error(response) {
                    console.log("Error response");
                    var status = response.status;
                    var config = response.config;
                    var method = config.method;
                    var url = config.url;

                    if (status == 401) {
                        console.log('401 Unauthorized: ', status);
                        $location.path("/login");
                    } else {
                        $rootScope.error = method + " on " + url + " failed with status " + status;
                    }
                    return $q.reject(response);
                }

                return function (promise) {
                    console.log('promise: ', promise);
                    return promise.then(success, error);
                }
            };

            $httpProvider.responseInterceptors.push(interceptor);

        }]
).run(function ($rootScope, $http, $location, $cookieStore) {

        $rootScope.$on('$viewContentLoaded', function () {
            console.log("Deleted error");
            delete $rootScope.error;
        });

        $rootScope.hasRole = function (role) {

            console.log("In function hasRole()");

            if ($rootScope.user === undefined) {
                console.log("user === undefined");
                return false;
            }
            if ($rootScope.user.roles[role] === undefined) {
                console.log("user.roles[role] === undefined");
                return false;
            }
            return $rootScope.user.roles[role];
        };

        $rootScope.logout = function () {
            console.log("In logout() function");
            delete $rootScope.user;
            delete $http.defaults.headers.common[xAuthTokenHeaderName];
            $cookieStore.remove('user');
            $location.path("/login");
        };

        var originalPath = $location.path();
        console.log("originalPath: ", originalPath);
        $location.path("/login");
        var user = $cookieStore.get('user');
        console.log("user: ", user);
        if (user !== undefined) {
            console.log("user !== undefined ");
            $rootScope.user = user;
            $http.defaults.headers.common[xAuthTokenHeaderName] = user.token;
            $location.path(originalPath);
        }
    });