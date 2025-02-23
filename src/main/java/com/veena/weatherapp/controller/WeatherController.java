package com.veena.weatherapp.controller;

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
            @RequestParam(defaultValue = "en") String lang) {
        System.out.println("HERE INPUT" + city +" "+unit+" "+lang);
        return weatherService.getCityWeather(city, unit, lang);
    }

    @GetMapping("/forecast")
    public Mono<String> getForecast(
            @RequestParam String city,
            @RequestParam(defaultValue = "metric") String unit,
            @RequestParam(defaultValue = "en") String lang) {
        return weatherService.getForecast(city, unit, lang);
    }
}
