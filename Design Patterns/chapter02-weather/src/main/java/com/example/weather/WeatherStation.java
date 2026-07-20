package com.example.weather;

import com.example.weather.data.WeatherData;
import com.example.weather.data.WeatherMeasurement;
import com.example.weather.display.CurrentConditionsDisplay;
import com.example.weather.display.ForecastDisplay;
import com.example.weather.display.HeatIndexDisplay;
import com.example.weather.display.StatisticsDisplay;

/**
 * WeatherStation – entry point.
 *
 * <p>Mô phỏng trạm đo thời tiết gửi dữ liệu 3 lần.
 * Mỗi lần {@code setMeasurements()} được gọi, tất cả display
 * tự động cập nhật nhờ Observer Pattern.
 *
 * <p><b>Observer Pattern:</b>
 * <ul>
 *   <li>Subject: {@link WeatherData}</li>
 *   <li>Observers: 4 display elements bên dưới</li>
 * </ul>
 */
public class WeatherStation {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        // Đăng ký observers – tự động nhận thông báo khi có dữ liệu mới
        new CurrentConditionsDisplay(weatherData);
        new StatisticsDisplay(weatherData);
        new ForecastDisplay(weatherData);
        new HeatIndexDisplay(weatherData);

        System.out.println("=== Measurement 1 ===");
        weatherData.setMeasurements(new WeatherMeasurement(29, 65, 1014.3f));

        System.out.println("\n=== Measurement 2 ===");
        weatherData.setMeasurements(new WeatherMeasurement(32, 70, 1010.5f));

        System.out.println("\n=== Measurement 3 ===");
        weatherData.setMeasurements(new WeatherMeasurement(25, 80, 1016.1f));
    }
}
