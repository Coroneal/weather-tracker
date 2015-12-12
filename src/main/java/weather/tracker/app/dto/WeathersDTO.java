package weather.tracker.app.dto;

import java.util.List;

/**
 * Created by pi12894 on 2015-12-01.
 */
public class WeathersDTO {

    List<WeatherDTO> weathers;

    public WeathersDTO(List<WeatherDTO> weathers) {
        this.weathers = weathers;
    }

    public List<WeatherDTO> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<WeatherDTO> weathers) {
        this.weathers = weathers;
    }

}
