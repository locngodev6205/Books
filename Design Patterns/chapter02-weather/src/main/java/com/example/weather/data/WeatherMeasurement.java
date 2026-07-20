package com.example.weather.data;

/**
 * WeatherMeasurement – gom 3 thông số vào một object bất biến.
 *
 * <p>Dùng Java Record (Java 16+): tự động có constructor,
 * getters, equals(), hashCode(), toString().
 */
public record WeatherMeasurement(
        float temperature,
        float humidity,
        float pressure
) {}
