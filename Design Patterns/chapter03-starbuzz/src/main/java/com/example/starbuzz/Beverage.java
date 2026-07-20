package com.example.starbuzz;

public abstract class Beverage {

    // ── Size ─────────────────────────────────────────────────────────────────

    public enum Size { TALL, GRANDE, VENTI }

    private Size size = Size.TALL;  // mặc định TALL

    public Size getSize()            { return size; }
    public void setSize(Size size)   { this.size = size; }

    // ── Description & Cost ───────────────────────────────────────────────────

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}