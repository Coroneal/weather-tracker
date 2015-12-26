angular.module('frontendServices', [])
    .service('MealService', ['$http', '$q', function ($http, $q) {
        return {}
    }])
    .service('WeatherService', ['$http', '$q', function ($http, $q) {
        return {
            getWeather: function () {
                var deferred = $q.defer();

                $http.get('/weather/')
                    .then(function (response) {
                        if (response.status == 200) {
                            deferred.resolve(response.data);
                        } else {
                            deferred.reject('Error retrieving list of meals');
                        }
                    });
                return deferred.promise;
            },
            getWeatherFromAPI: function () {
                var deferred = $q.defer();

                var key = '20e818b3efbe65c01ea2b3c7629937c4';
                var days = '4';
                var cityID = '7530768';
                var url = 'http://api.openweathermap.org/data/2.5/forecast?';

                var address = url + 'id=' + cityID + '&cnt=' + days + '&APPID=' + key;

                $http.jsonp(address, {
                        params: {
                            callback: 'JSON_CALLBACK'
                        }
                    })
                    .success(function (data, status, headers, config) {
                        deferred.resolve(data);
                    }).error(function (data, status, headers, config) {
                    deferred.reject(err);
                });
                return deferred.promise;
            }
        }
    }]);