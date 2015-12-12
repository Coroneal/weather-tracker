package weather.tracker.app.services;

import weather.tracker.app.dao.WeatherRepository;
import weather.tracker.app.model.SearchResult;
import weather.tracker.app.model.Weather;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pi12894 on 2015-12-01.
 */
@Service
public class WeatherService {

    private static final Logger LOGGER = Logger.getLogger(WeatherService.class);

    @Autowired
    WeatherRepository weatherRepository;

    @Transactional(readOnly = true)
    public SearchResult<Weather> findWeathers() {

        List<Weather> resultsList = weatherRepository.getWeathers();
        return new SearchResult<>(resultsList.size(), resultsList);
    }

    @Transactional
    public Integer avgTemperature() {
        return weatherRepository.avgTemperature();
    }
}
