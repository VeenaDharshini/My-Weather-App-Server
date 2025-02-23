package com.veena.weatherapp.controller;

import com.veena.weatherapp.dto.CityWeatherRequestDto;
import com.veena.weatherapp.dto.CityWeatherResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.veena.weatherapp.service.WeatherService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public Mono<CityWeatherResponseDto> getCityWeather(
            @RequestParam String city,
            @RequestParam(defaultValue = "metric") String unit,
            @RequestParam(defaultValue = "en") String lang,
            @RequestParam Double lon,
            @RequestParam Double lat,
            @RequestParam Long dt
    ) {
        CityWeatherRequestDto requestDto = new CityWeatherRequestDto();
        requestDto.setCityName(city);
        requestDto.setUnit(unit);
        requestDto.setLanguage(lang);
        requestDto.setLatitude(lat);
        requestDto.setLongitude(lon);
        requestDto.setTimeDifference(dt);
        return weatherService.getCityWeather(requestDto);
    }

    @GetMapping("/forecast")
    public Mono<String> getForecast(
            @RequestParam String city,
            @RequestParam(defaultValue = "metric") String unit,
            @RequestParam(defaultValue = "en") String lang) {
        return weatherService.getForecast(city, unit, lang);
    }
}
