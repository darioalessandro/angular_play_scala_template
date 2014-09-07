/*
@author Dario A Lencina-Talarico
*/

var app = angular.module("app", ["ngResource", "ngRoute"])
    .config(["$routeProvider", function($routeProvider) {
        return $routeProvider.when("/", {
            templateUrl: "/views/login",
            controller: "LoginController"
        }).when("/create", {
            templateUrl: "/views/main",
            controller: "MainScreenController"
        }).when("/edit/:id", {
            templateUrl: "/views/details",
            controller: "DetailsController"
        }).otherwise({
            redirectTo: "/"
        });
    }
    ]);

// the global controller
app.controller("AppCtrl", ["$scope", "$location", function($scope, $location) {
    // the very sweet go function is inherited by all other controllers
    $scope.go = function (path) {
        $location.path(path);
    };
}]);