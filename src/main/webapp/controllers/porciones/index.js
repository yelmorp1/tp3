app.controller('PorcionCtrl', function ($scope, porcionesSimuladorFtry) { 
   $scope.showNoData = false;
    porcionesSimuladorFtry.get().success(function (data) {
       console.log(data);
    }).error(function(err){
    });
})
app.controller('PorcionSimuladorCtrl', function ($scope, porcionesSimuladorFtry) { 
    $scope.showNoData = false;
    porcionesSimuladorFtry.get().success(function (data) {
       console.log(data);
    }).error(function(err){
    });

})



