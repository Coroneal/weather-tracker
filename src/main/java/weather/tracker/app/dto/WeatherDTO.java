package weather.tracker.app.dto;

import weather.tracker.app.model.Weather;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pi12894 on 2015-12-01.
 */
public class WeatherDTO {

    private Long id;

    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "CET")
    private Date date;

    private String description;
    private int temperature;

    public WeatherDTO(Long id, int temperature, String description, Date date) {
        this.id = id;
        this.temperature = temperature;
        this.description = description;
        this.date = date;
    }

    public static WeatherDTO mapFromWeatherEntity(Weather weather) {
        return new WeatherDTO(weather.getId(), weather.getTemperature(), weather.getDescription(), weather.getDate());
    }

    public static List<WeatherDTO> mapFromWeathersEntities(List<Weather> weathers) {
        return weathers.stream().map((meal) -> mapFromWeatherEntity(meal)).collect(Collectors.toList());
    }

    public WeatherDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
