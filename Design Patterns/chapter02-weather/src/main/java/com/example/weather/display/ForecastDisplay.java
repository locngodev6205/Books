package com.example.weather.display;

import com.example.weather.data.WeatherData;
import com.example.weather.data.WeatherMeasurement;
import com.example.weather.observer.DisplayElement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Hiển thị dự báo thời tiết dựa trên xu hướng áp suất.
 */
public class ForecastDisplay implements PropertyChangeListener, DisplayElement {

    private float currentPressure = 1013.25f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("measurements".equals(evt.getPropertyName())) {
            WeatherMeasurement m = (WeatherMeasurement) evt.getNewValue();
            lastPressure    = currentPressure;
            currentPressure = m.pressure();
            display();
        }
    }

    @Override
    public void display() {
        String forecast;
        if (currentPressure > lastPressure) {
            forecast = "Improving weather on the way!";
        } else if (currentPressure == lastPressure) {
            forecast = "More of the same";
        } else {
            forecast = "Watch out for cooler, rainy weather";
        }
        System.out.println("Forecast: " + forecast);
    }
}
