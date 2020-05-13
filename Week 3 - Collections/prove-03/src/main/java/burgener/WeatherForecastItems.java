package burgener;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class WeatherForecastItems {

    @SerializedName("main")
    private Map<String,Float> measurements;

    private List<WeatherDescription> weather;

    @SerializedName("dt_txt")
    private String time;

    private WindSpeed wind;

    public String getTime() {

        return time;
    }

    public Float getMain() {

        return measurements.get("temp");
    }

    public String getCondition() {

        return weather.get(0).getDescription();
    }

    public Float getWind() {

        return wind.getSpeed();
    }
}
