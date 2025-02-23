package com.veena.weatherapp.dto;

import lombok.Data;

@Data
public class CityWeatherRequestDto {
    private String cityName;
    private String unit;
    private String language;
    private Double latitude;
    private Double longitude;
    private Long timeDifference;
}
