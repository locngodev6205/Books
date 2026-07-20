package com.example.weather.display;

import com.example.weather.data.WeatherData;
import com.example.weather.data.WeatherMeasurement;
import com.example.weather.observer.DisplayElement;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Hiển thị thống kê nhiệt độ: trung bình, min, max.
 */
public class StatisticsDisplay implements PropertyChangeListener, DisplayElement {

    private float maxTemp = Float.MIN_VALUE;
    private float minTemp = Float.MAX_VALUE;
    private float tempSum = 0;
    private int   numReadings = 0;

    public StatisticsDisplay(WeatherData weatherData) {
        weatherData.addObserver(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("measurements".equals(evt.getPropertyName())) {
            WeatherMeasurement m = (WeatherMeasurement) evt.getNewValue();
            float temp = m.temperature();
            tempSum += temp;
            numReadings++;
            if (temp > maxTemp) maxTemp = temp;
            if (temp < minTemp) minTemp = temp;
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = "
                + String.format("%.1f", tempSum / numReadings) + "/"
                + String.format("%.1f", maxTemp) + "/"
                + String.format("%.1f", minTemp) + "C");
    }
}
