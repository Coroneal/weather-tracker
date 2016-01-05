angular.module('weatherApp', ['frontendServices'])

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

        $scope.getBackgroundStyle = function(image){
            return {
                'background-image':'url(/resources/img/' + result.desc + '.jpg)'
            }
        };


        // get day
        var getDay = function (dayNumber, data) {
            var result = {};
            var day = data.list[dayNumber];
            result.temp = day.main.temp;
            result.desc = day.weather[0].main;
            result.backg = "{'background-image':'url(/resources/img/" + result.desc + ".jpg)'}";
            return result;
        };

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
                console.log(getDay(0, data));
                $scope.actualDay = getDay(0, data);
                $scope.day1 = getDay(1, data);
                $scope.day2 = getDay(2, data);
                $scope.day3 = getDay(3, data);
            });

    }])
    .controller('WeatherTrackerCtrl', ['$scope', 'MealService', '$timeout',
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

