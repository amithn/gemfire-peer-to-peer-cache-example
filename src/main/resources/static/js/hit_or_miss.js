//See: https://github.com/pablojim/highcharts-ng
var myapp = angular.module('myapp', []);

myapp.controller('myctrl', ['$scope','$http', function($scope, $http)  {
     $scope.ids = [];
     $scope.entries = [];

     for(id=0; id<10; id++) {
        $scope.ids.push(id);
     }

     $scope.selected_id = 1;

     $scope.fetch = function(selected_id) {
         var id = selected_id;
         $http.get('/quote/' + id).then(function(response) {
                if(response.status == 200) {
                    console.log("Response " + JSON.stringify(response.data));
                    $scope.entries.unshift(response.data);
            }
         });
     }
}]);