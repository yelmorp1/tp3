app.factory("porcionesSimuladorFtry", function ($http, $location, $rootScope) {
    return {
        get: function (id) {
            return $http({
                //url: 'http://localhost:8080/tp3/porciones/lista/insumos/',
                url: 'http://d7c87227.ngrok.io/tp3/porciones/lista/insumos/',
                method: 'GET'
            });
        }
    }
});