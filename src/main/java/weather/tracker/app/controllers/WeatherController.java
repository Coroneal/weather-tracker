package weather.tracker.app.controllers;

import weather.tracker.app.dto.WeatherDTO;
import weather.tracker.app.dto.WeathersDTO;
import weather.tracker.app.model.SearchResult;
import weather.tracker.app.model.Weather;
import weather.tracker.app.services.WeatherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("weather")
public class WeatherController {

    Logger LOGGER = Logger.getLogger(MealController.class);

    @Autowired
    private WeatherService weatherService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET)
    public WeathersDTO getWeathers() {
        SearchResult<Weather> result = weatherService.findWeathers();
        return new WeathersDTO(WeatherDTO.mapFromWeathersEntities(result.getResult()));
    }

    //    @ResponseBody
    //    @ResponseStatus(HttpStatus.OK)
    //    @RequestMapping(method = RequestMethod.GET)
    //    public Integer avgTemperature() {
    //
    //        Integer avgTemperature = weatherService.avgTemperature();
    //
    //        return avgTemperature;
    //    }

}
