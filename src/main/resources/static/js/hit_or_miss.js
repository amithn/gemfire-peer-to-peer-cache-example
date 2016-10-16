var myapp = angular.module('myapp', []);

myapp.controller('myctrl', ['$scope','$http', function($scope, $http)  {
     $scope.ids = [];
     $scope.entries = [];
     $scope.selected_id = 1;

     $scope.fetch = function(selected_id) {
         var id = selected_id;
         $http.get('/quotes/' + id).then(function(response) {
                if(response.status == 200) {
                    console.log("Response " + JSON.stringify(response.data));
                    $scope.entries.unshift(response.data);
            } else {
                //TODO: Report error to the user
            }
         });
     }
}]);