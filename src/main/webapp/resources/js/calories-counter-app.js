angular.module('caloriesCounterApp', ['frontendServices'])

    .controller('WeatherCtrl', ['$scope', 'WeatherService', '$timeout', function ($scope, WeatherService, $timeout) {
        // Build the date object
        $scope.date = {};

        // Update function
        var updateTime = function () {
            $scope.date.raw = new Date();
            $timeout(updateTime, 1000);
        };

        // Kick off the update function
        updateTime();

        $scope.weather = {};
        // Hardcode San_Francisco for now
        WeatherService.getWeather()
            .then(function (data) {
                var log = [];
                angular.forEach(data.weathers, function (value) {
                    value.img = 'resources/img/' + value.description + '.png';
                }, log);
                $scope.weather.forecast = data;
            });

        WeatherService.getWeatherFromAPI()
            .then(function (data) {
                console.log('FOUND II!');
                console.log(data);
                $scope.weatherAPI = data;
            });

    }])
    .controller('CaloriesTrackerCtrl', ['$scope', 'MealService', '$timeout',
        function ($scope) {
            $scope.vm = {
                maxCaloriesPerDay: 2000,
                currentPage: 1,
                totalPages: 0,
                originalMeals: [],
                meals: [],
                isSelectionEmpty: true,
                errorMessages: [],
                infoMessages: []
            };
            function markAppAsInitialized() {
                if ($scope.vm.appReady == undefined) {
                    $scope.vm.appReady = true;
                }
            }
            markAppAsInitialized();

        }]);

