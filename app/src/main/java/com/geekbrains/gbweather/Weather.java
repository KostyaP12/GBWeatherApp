package com.geekbrains.gbweather;

public class Weather {
    private String dayOfWeek;
    private String temperature;
    private int weatherIcon;

    public Weather(String dayOfWeek, String temperature, int weatherIcon) {
        this.dayOfWeek = dayOfWeek;
        this.temperature = temperature;
        this.weatherIcon = weatherIcon;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }
}
