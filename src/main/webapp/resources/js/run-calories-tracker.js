///////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Defines the javascript files that need to be loaded and their dependencies.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////

require.config({
    paths: {
        angular: '../bower_components/angular/angular',
        angularMessages: '../bower_components/angular-messages/angular-messages',
        frontendServices: 'frontend-services',
        caloriesCounterApp: "calories-counter-app"
    },
    shim: {
        angular: {
            exports: "angular"
        },
        angularMessages: {
            deps: ['angular']
        },
        frontendServices: {
            deps: ['angular']
        },
        caloriesCounterApp: {
            deps: ['angular', 'angularMessages', 'frontendServices']
        }
    }
});

require(['caloriesCounterApp'], function () {

    angular.bootstrap(document.getElementById('caloriesCounterApp'), ['caloriesCounterApp']);

});