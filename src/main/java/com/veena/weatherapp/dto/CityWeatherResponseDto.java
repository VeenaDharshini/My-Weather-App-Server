package com.veena.weatherapp.dto;

import lombok.Data;

@Data
public class CityWeatherResponseDto {
    private String cityName;
    private Double temperature;
    private Double humidity;
    private Double pressure;
    private Double windSpeed;
    private String description;
    private Double longitude;
    private Double latitude;
}
