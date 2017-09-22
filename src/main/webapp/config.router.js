'use strict';

/**
 * @ngdoc function
 * @name app.config:uiRouter
 * @description
 * # Config
 * Config for the router
 */
angular.module('app')
  .run(
    [           '$rootScope', '$state', '$stateParams',
      function ( $rootScope,   $state,   $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
        //$rootScope.baseUrl = "http://localhost:5375/api";
        $rootScope.baseUrl = "http://grpwebapi.azurewebsites.net/api";
      }
    ]
  )
  .config(
    [          '$stateProvider', '$urlRouterProvider',
      function ( $stateProvider,   $urlRouterProvider) 
      {
        var layout = 'views/layout.html';
        var aside  = 'views/aside.html';
        var content= 'views/content.html';
        
        $urlRouterProvider
          .otherwise('/app/home');
        $stateProvider
          .state('app', {
            abstract: true,
            url: '/app',
            views: {
              '': {
                templateUrl: layout
              },
              'aside': {
                templateUrl: aside
              },
              'content': {
                templateUrl: content
              }
            }
          })
          .state('app.home', {
            url: '/home',
            templateUrl: 'views/home.html',
            resolve: {
              load: function($ocLazyLoad) {
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'styles/flexslider.css',
                    'libs/jquery/jquery.flexslider.js',
                    'controllers/home.js'
                    ]
                  });
                }
              }
          })
          .state('app.producto',{
            url: '/producto',
            templateUrl: 'views/producto/index.html',
            resolve: {
              load: function($ocLazyLoad){
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'models/producto.js',
                    'controllers/producto/index.js'
                  ]
                });
              }
            }
          })
          .state('app.crearProducto',{
            url: '/producto/nuevo',
            templateUrl: 'views/producto/create.html',
            resolve: {
              load: function($ocLazyLoad){
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'controllers/producto/create.js',
                    'controllers/insumos-modal.js',
                    'models/categoria.js',
                    'models/articulo.js',
                    'models/nutricional.js',
                    'models/producto.js'
                  ]
                });
              }
            }
          })
          .state('app.editarProducto',{
            url: '/producto/{id:[0-9]{1,4}}',
            templateUrl: 'views/producto/editar.html',
            resolve: {
              load: function($ocLazyLoad){
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'controllers/producto/edit.js',
                    'controllers/insumos-modal.js',
                    'models/categoria.js',
                    'models/articulo.js',
                    'models/nutricional.js',
                    'models/producto.js'
                  ]
                });
              }
            }
          })
          .state('app.solicitudRetiro',{
            url: '/solicitudretiro',
            templateUrl: 'views/solicitudretiro/index.html',
            resolve: {
              load: function($ocLazyLoad){
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'models/solicitudretiro.js',
                    'controllers/solicitudretiro/index.js'
                  ]
                });
              }
            }
          })
          .state('app.crearSolicitudRetiro',{
            url: '/solicitudretiro/nuevo',
            templateUrl: 'views/solicitudretiro/create.html',
            resolve: {
              load: function($ocLazyLoad){
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'models/solicitudretiro.js',
                    'models/combo.js',
                    'controllers/insumos-modal.js',                    
                    'controllers/solicitudretiro/create.js'                    
                  ]
                });
              }
            }
          })
          .state('app.controlporciones',{
            url: '/porciones',
            templateUrl: 'views/porciones/index.html',
            resolve: {
              load: function($ocLazyLoad){
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'models/porciones.js',
                    'models/producto.js',
                    'controllers/porciones/index.js'
                  ]
                });
              }
            }
          })
          .state('app.simularporciones',{
            url: '/porciones/simular',
            templateUrl: 'views/porciones/simular.html',
            resolve: {
              load: function($ocLazyLoad){
                return $ocLazyLoad.load({
                  name: "app",
                  files: [
                    'models/porciones.js',
                    'models/categoria.js',
                    'controllers/porciones/index.js'
                  ]
                });
              }
            }
          });
      }
    ]
  );