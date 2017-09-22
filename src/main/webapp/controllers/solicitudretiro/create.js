app.controller('SolicitudRetiroCrearCtrl', function ($scope, $state, $modal, 
    SolicitudRetiroFtry, ComboFtry) {
    $scope.solicitudretiro = {
        'Comentario': '',
        'IdProyeccion': '0',
        'IdSimulacion': '0'
    };
    $scope.PorcentajeAporteAfecto = parseFloat(0); // acumulado de % aporte de combos a retirar
    $scope.PorcentajeAporteSimulacion = parseFloat(0); // acumulado de % de aporte de combos en simmulacion
    $scope.CombosxRetiro = [];
    $scope.CombosxProyeccion = [];
    $scope.IngresoProyectadoAfecto = parseFloat(0);
   
    ComboFtry.getAll().success(function (data) {
        $scope.listaCombo = data;
    });

    $scope.open = function (size) {
        var modalInstance = $modal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalInstanceCtrl',
            size: size,
            resolve: {
                items: function () {
                    return $scope.listaCombo;
                }
            }
        });
        modalInstance.result.then(function (selectedItem) {
            //$scope.selected = selectedItem;
            var nuevoCombo = {};
            nuevoCombo.Id = selectedItem.item.Id;
            nuevoCombo.Nombre = selectedItem.item.Nombre;
            nuevoCombo.VentaProyectada = parseFloat(selectedItem.item.MontoProyectado);
            nuevoCombo.PorcentajeAporte = parseFloat(selectedItem.item.PorcentajeAporte);
            nuevoCombo.VentaReal = parseFloat(selectedItem.item.VentaPeriodo);
            nuevoCombo.Saldo = parseFloat(selectedItem.item.MontoProyectado-selectedItem.item.VentaPeriodo);
            nuevoCombo.PorcentajeCumplimiento = parseFloat(nuevoCombo.VentaReal/nuevoCombo.VentaProyectada).toFixed(4);
            $scope.PorcentajeAporteAfecto += parseFloat(selectedItem.item.PorcentajeAporte);
            $scope.IngresoProyectadoAfecto += parseFloat(nuevoCombo.Saldo); // Calculando el IPA         
            console.log($scope.IngresoProyectadoAfecto);
            console.log($scope.PorcentajeAporteAfecto);
            $scope.CombosxRetiro.push(nuevoCombo);
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };

    $scope.open2 = function (size) {
        var modalInstance = $modal.open({
            templateUrl: 'modalContent.html',
            controller: 'ModalInstanceCtrl',
            size: size,
            resolve: {
                items: function () {
                    return $scope.listaCombo;
                }
            }
        });
        modalInstance.result.then(function (selectedItem) {
            //$scope.selected = selectedItem;
            var nuevoRegistro = {};
            nuevoRegistro.Id = selectedItem.item.Id;
            nuevoRegistro.Nombre = selectedItem.item.Nombre;
            nuevoRegistro.VentaProyectada = parseFloat(selectedItem.item.MontoProyectado);
            nuevoRegistro.PorcentajeAporte = parseFloat(selectedItem.item.PorcentajeAporte).toFixed(4);
            nuevoRegistro.VentaReal = parseFloat(selectedItem.item.VentaPeriodo);
            nuevoRegistro.PorcentajeNuevoAporte = parseFloat(0);
            $scope.PorcentajeAporteSimulacion += parseFloat(selectedItem.item.PorcentajeAporte);
            nuevoRegistro.VentaProyectadaNueva = parseFloat(0);
            $scope.CombosxProyeccion.push(nuevoRegistro); // otro comentario para probar git

            //nuevoRegistro.pesoInterno = parseFloat(0);
            //nuevoRegistro.PorcentajeAporteAfecto = $scope.PorcentajeAporteAfecto;
            //nuevoRegistro.PorcentajeAporteSimulacion = $scope.PorcentajeAporteSimulacion;
            //nuevoRegistro.IngresoProyectadoAfecto =$scope.IngresoProyectadoAfecto;

            realizarSimulacion();
            console.log(nuevoRegistro);            
        }, function () {
            //$log.info('Modal dismissed at: ' + new Date());
        });
    };

    function realizarSimulacion(){
        var pesoInterno = parseFloat(0);
        var comboSimulado; 
        var nuevoAporte = parseFloat(0); 
        var nuevoPorcentaje = parseFloat(0);  

        for (var idx = 0; idx < $scope.CombosxProyeccion.length; idx++) {
            comboSimulado = $scope.CombosxProyeccion[idx];
            pesoInterno = parseFloat(comboSimulado.PorcentajeAporte/$scope.PorcentajeAporteSimulacion).toFixed(4);
            $scope.CombosxProyeccion[idx].pesoInterno = pesoInterno;
            nuevoAporte = parseFloat(comboSimulado.VentaProyectada)+parseFloat(pesoInterno)*parseFloat($scope.IngresoProyectadoAfecto);
            $scope.CombosxProyeccion[idx].VentaProyectadaNueva = nuevoAporte;
            nuevoAporte = parseFloat($scope.PorcentajeAporteAfecto)*parseFloat(pesoInterno)+parseFloat(comboSimulado.PorcentajeAporte);
            $scope.CombosxProyeccion[idx].PorcentajeNuevoAporte = parseFloat(nuevoAporte).toFixed(4);
        }
    }

    $scope.grabar = function(){
        $scope.solicitudretiro.Retiro = $scope.CombosRetiro;
        $scope.solicitudretiro.Proyeccion = $scope.CombosProyeccion;
        SolicitudRetiroFtry.create($scope.solicitudretiro).success(function (data) {
            alert("Datos grabados");
            $state.go("app.solicitudretiro");
        }).error(function (data) {

        });
    }
})