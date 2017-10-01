 app.factory("ProductoFtry", function ($http, $location, $rootScope) {
    return {
        get: function (id) {
            return $http({
                url: $rootScope.baseUrl + '/producto/' + id,
                method: 'GET'
            });
        },
        getAll: function () {
            return $http({
                url: $rootScope.baseUrl + '/producto',
                method: 'GET'
            });
        },
        getDetails: function (id) {
            return $http({
                url: $rootScope.baseUrl + '/producto/' + id + '/details',
                method: 'GET'
            });
        },
        update: function (data) {
            return $http({
                url: $rootScope.baseUrl + '/producto',
                method: "PUT",
                data: data,
                headers: { 'Content-Type': 'application/json' }
            });
        },
        create: function (data) {
            return $http({
                url: $rootScope.baseUrl + '/producto',
                method: "POST",
                data: data,
                headers: { 'Content-Type': 'application/json' }
            });
        },
        delete: function (data) {
            return $http({
                url: 'data/Area/delete',
                method: "POST",
                data: data,
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
            });
        }
    }
});