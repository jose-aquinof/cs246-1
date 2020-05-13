package burgener;

import java.util.List;

public class WeatherForecast {

    String baseUrl = "https://api.openweathermap.org/data/2.5/forecast?q=";

    public List<WeatherForecastItems> getList() {
        return list;
    }

    private List<WeatherForecastItems> list;


}
