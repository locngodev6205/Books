package com.example.weather.display;

import com.example.weather.data.WeatherData;
import com.example.weather.data.WeatherMeasurement;
import com.example.weather.observer.DisplayElement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Hiển thị chỉ số nhiệt cảm nhận (Heat Index).
 */
public class HeatIndexDisplay implements PropertyChangeListener, DisplayElement {

    private float heatIndex;

    public HeatIndexDisplay(WeatherData weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("measurements".equals(evt.getPropertyName())) {
            WeatherMeasurement m = (WeatherMeasurement) evt.getNewValue();
            this.heatIndex = computeHeatIndex(m.temperature(), m.humidity());
            display();
        }
    }

    private float computeHeatIndex(float t, float rh) {
        float tf = t * 9.0f / 5.0f + 32.0f;
        float hi = (float) (
                -42.379
                + 2.04901523  * tf
                + 10.14333127 * rh
                - 0.22475541  * tf * rh
                - 0.00683783  * tf * tf
                - 0.05481717  * rh * rh
                + 0.00122874  * tf * tf * rh
                + 0.00085282  * tf * rh * rh
                - 0.00000199  * tf * tf * rh * rh);
        return (hi - 32.0f) * 5.0f / 9.0f;
    }

    @Override
    public void display() {
        System.out.println("Heat index is " + String.format("%.2f", heatIndex) + "C");
    }
}
