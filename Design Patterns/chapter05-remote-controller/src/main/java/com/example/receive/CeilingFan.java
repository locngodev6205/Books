package com.example.receive;

public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }
    public void high() {
        speed = HIGH;
        // code to set fan to high
        System.out.println("High");
    }
    public void medium() {
        speed = MEDIUM;
        // code to set fan to medium
        System.out.println("medium");
    }
    public void low() {
        speed = LOW;
        // code to set fan to low
        System.out.println("low");
    }
    public void off() {
        speed = OFF;
        // code to turn fan off
        System.out.println("off");
    }
    public int getSpeed() {
        return speed;
    }
}
