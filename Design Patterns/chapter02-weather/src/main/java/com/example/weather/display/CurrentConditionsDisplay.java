package com.example.weather.display;

import com.example.weather.data.WeatherData;
import com.example.weather.data.WeatherMeasurement;
import com.example.weather.observer.DisplayElement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Hiển thị điều kiện thời tiết hiện tại.
 */
public class CurrentConditionsDisplay implements PropertyChangeListener, DisplayElement {

    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("measurements".equals(evt.getPropertyName())) {
            WeatherMeasurement m = (WeatherMeasurement) evt.getNewValue();
            this.temperature = m.temperature();
            this.humidity    = m.humidity();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "C and " + humidity + "% humidity");
    }
}
