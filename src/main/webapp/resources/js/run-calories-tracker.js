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
        weatherApp: "weather-app"
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
        weatherApp: {
            deps: ['angular', 'angularMessages', 'frontendServices']
        }
    }
});

require(['weatherApp'], function () {

    angular.bootstrap(document.getElementById('weatherApp'), ['weatherApp']);

});