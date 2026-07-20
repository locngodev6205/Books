package com.example.weather.data;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * WeatherData – Concrete Subject (Observable).
 *
 * <p>Đây là nguồn dữ liệu thời tiết. Khi measurements thay đổi,
 * nó tự động thông báo tới tất cả Observer đã đăng ký.
 *
 * <p><b>Design principle:</b>
 * <em>"Strive for loosely coupled designs between objects that interact."</em>
 */
public class WeatherData {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private WeatherMeasurement current;

    public void addObserver(PropertyChangeListener l) {
        support.addPropertyChangeListener(l);
    }

    public void removeObserver(PropertyChangeListener l) {
        support.removePropertyChangeListener(l);
    }
    

    // ── Gọi khi trạm đo có số liệu mới ──────────────────────────────────────

    /**
     * Được gọi bởi weather station khi có measurements mới.
     * Lưu dữ liệu rồi thông báo tất cả observer.
     */
    public void setMeasurements(WeatherMeasurement newValue) {
        this.current = newValue;
        measurementsChanged();
    }

    private void measurementsChanged() {
        support.firePropertyChange("measurements", null, this.current);
    }

    // ── Getters ───────────────────────────────────────────────────────────────

    public float getTemperature() { return current.temperature(); }
    public float getHumidity()    { return current.humidity(); }
    public float getPressure()    { return current.pressure(); }
}
