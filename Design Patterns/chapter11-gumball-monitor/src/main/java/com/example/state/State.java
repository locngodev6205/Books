package com.example.state;

import java.io.Serializable;

// Object có thể được chuyển thành một chuỗi byte (serialize).
public interface State extends Serializable {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}
