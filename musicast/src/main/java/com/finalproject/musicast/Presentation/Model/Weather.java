package com.finalproject.musicast.Presentation.Model;

import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

import java.io.IOException;

public class Weather {

    private String location;
    private float temperature;
    private String forecast;

    public Weather() {
    }

    public Weather(String location, float temperature, String forecast) {
        this.location = location;
        this.temperature = temperature;
        this.forecast = forecast;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public void update (float temperature, float rain, String location){
        this.temperature = temperature;
        this.location = location;
        this.forecast=(rain > 40?forecast="rainy":"sunny");
    }
}
