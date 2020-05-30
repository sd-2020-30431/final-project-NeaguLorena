package com.finalproject.musicast;

import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    public static float getTemperatureAPI() throws IOException {
        String owmApiKey = "048face306a7d80f175187e13e2f3a62";
        String weatherCity = "London";
        DailyForecast.Forecast.Temperature temperature = null;
        byte forecastDays = 3;
        OpenWeatherMap.Units units = OpenWeatherMap.Units.METRIC;
        OpenWeatherMap owm = new OpenWeatherMap(units, owmApiKey);
        try {
            DailyForecast forecast = owm.dailyForecastByCityName(weatherCity, forecastDays);
            DailyForecast.Forecast dayForecast = forecast.getForecastInstance(0);
            temperature = dayForecast.getTemperatureInstance();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        assert temperature != null;
        return temperature.getMaximumTemperature();
    }
}
