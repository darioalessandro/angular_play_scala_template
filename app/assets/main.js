/*
@author Dario A Lencina-Talarico
*/

var app = angular.module("app", ["ngResource", "ngRoute"])
    .config(["$routeProvider", function($routeProvider) {
        return $routeProvider.when("/", {
            templateUrl: "/angularjs/html/login",
            controller: "LoginController"
        }).when("/main", {
            templateUrl: "/angularjs/html/main",
            controller: "MainScreenController"
        }).when("/carDetails/:id", {
            templateUrl: "/angularjs/html/details",
            controller: "DetailsController"
        });

        //.otherwise({
          //  redirectTo: "/"
        //});
    }
    ]);

// the global controller
app.controller("AppCtrl", ["$scope", "$location", function($scope, $location) {
    // the very sweet go function is inherited by all other controllers
    $scope.go = function (path) {
        $location.path(path);
    };
}]);

app.controller("LoginController", ["$scope", "$http","$timeout", function($scope, $http,$timeout) {
	$scope.login=function(user){
        if(typeof user !== "undefined"  && typeof user.email !== "undefined" && typeof  user.pass !== "undefined"){
            $http.post('/api/login',user)
            .success(function(data, status, headers, config) {
                $scope.loginError=null;
                $timeout(function() { $scope.go('/main'); });
            }).error(function(data, status, headers, config) {
                if(status===401){
                    $scope.loginError="Las credenciales son incorrectas.";
                }else if(status==500){
                    $scope.loginError="Error interno del servidor, verifique la aplicación está corriendo.";
                }else{
                    $scope.loginError="Error desconocido.";
                }
            });
        }
	};

	$scope.hasLoginError=function(){
        return (typeof $scope.loginError !== "undefined");
	};

}]);

app.controller("MainScreenController", ["$scope", "$resource","$timeout", function($scope, $resource, $timeout) {
	var Coches= $resource('/api/cars');
	$scope.coches= Coches.query(function() {});

	$scope.showDetails=function(coche){
        $timeout(function() { $scope.go('/carDetails/'+coche.id); });
	};
}]);

app.controller("DetailsController", ["$scope", "$resource","$routeParams", function($scope, $resource,$routeParams) {
	var CocheDetails = $resource("/api/carDetails", {id:"@id"});
    if ($routeParams.id) {
        $scope.coche = CocheDetails.get({id: $routeParams.id});
    }
}]);