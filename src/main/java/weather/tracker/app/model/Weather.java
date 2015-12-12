package weather.tracker.app.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The User JPA entity.
 */
@Entity
@Table(name = "WEATHER")
//@NamedQueries({
//        @NamedQuery(
//                name = Weather.AVG_WEATHER,
//                query = "select avg(w.temperature) from Weather w"
//        )
//})
public class Weather extends AbstractEntity {

    //    public static final String AVG_WEATHER = "weather.avgWeather";

    private Date date;
    private Integer temperature;
    private String description;

    public Weather() {
    }

    public Weather(Date date, String description, int temperature) {
        this.date = date;
        this.description = description;
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", temp='" + temperature + '\'' +
                ", desc=" + description +
                '}';
    }
}
