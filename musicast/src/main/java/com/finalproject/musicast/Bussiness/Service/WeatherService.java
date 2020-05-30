package com.finalproject.musicast.Bussiness.Service;

import com.finalproject.musicast.Presentation.Model.Weather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    public static void getTemperatureAPI(Weather weather) throws IOException {
        String owmApiKey = "048face306a7d80f175187e13e2f3a62";
        String weatherCity = "London";
        DailyForecast.Forecast.Temperature temperature = null;
        byte forecastDays = 3;
        OpenWeatherMap.Units units = OpenWeatherMap.Units.METRIC;
        OpenWeatherMap owm = new OpenWeatherMap(units, owmApiKey);
        float rain = 0;
        try {
            DailyForecast forecast = owm.dailyForecastByCityName(weatherCity, forecastDays);
            DailyForecast.Forecast dayForecast = forecast.getForecastInstance(0);
            temperature = dayForecast.getTemperatureInstance();
            rain = dayForecast.getRain();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        assert temperature != null;
        weather.update(temperature.getDayTemperature(), rain, weatherCity);
    }
}
