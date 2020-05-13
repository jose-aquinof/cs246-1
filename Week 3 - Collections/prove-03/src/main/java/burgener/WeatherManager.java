package burgener;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import com.google.gson.Gson;

public class WeatherManager {

    // Method to encode a string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }

    public static void main(String args[]) throws Exception
    {
        WeatherForecast forecast = new WeatherForecast();
        String forecastUrl = forecast.baseUrl;
        String baseUrl = "https://api.openweathermap.org/data/2.5/weather?q=";

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter city: ");
        String city = myObj.nextLine();

        // put null at the end when I'm done
        String key = "d85c63c17c9d66ba9d207849a9556024";
        String encodedQuery = encodeValue(key);

        // added units=imperial to convert from kelvin to fahrenheit
        String completeBaseUrl = baseUrl + city + "&units=imperial" + "&apiKey=" + encodedQuery;
        String completeForecastUrl = forecastUrl + city + "&units=imperial" + "&apiKey=" + encodedQuery;
        // System.out.println(completeUrl);

        InputStream responseBase = new URL(completeBaseUrl).openStream();
        InputStream responseForecast = new URL(completeForecastUrl).openStream();


        try (Scanner scanner = new Scanner(responseBase)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            //System.out.println(responseBody);

            Gson gson = new Gson();
            WeatherConditions weather = gson.fromJson(responseBody, WeatherConditions.class);
            System.out.println(weather);
        }

        try (Scanner scanner = new Scanner(responseForecast)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.println(responseBody);

            Gson gson = new Gson();
            WeatherForecast weather = gson.fromJson(responseBody, WeatherForecast.class);
            for (WeatherForecastItems item: weather.getList()) {
                System.out.format("Day and time: " + item.getTime() + "\n");
                System.out.format("The forecast temperature is: " + item.getMain() + "\n");
                System.out.format("The condition is: " + item.getCondition() + "\n");
                System.out.format("The wind speed is: " + item.getWind() + "\n");
            }
        }
    }
}
