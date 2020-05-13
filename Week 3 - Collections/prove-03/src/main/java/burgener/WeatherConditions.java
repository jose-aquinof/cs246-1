package burgener;

import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class WeatherConditions {

    private int id;
    private String name;
    @SerializedName("main")
    private Map<String,Float> measurements;

    public String toString() {

        return "ID: " + id + "\nName: " + name + "\nMeasurements: " + measurements;

    }
}
