package com.veena.weatherapp.controller;

import com.veena.weatherapp.dto.CityWeatherRequestDto;
import com.veena.weatherapp.dto.CityWeatherResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.veena.weatherapp.service.WeatherService;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("api")
public class WeatherController {
    private static final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;

    @PostMapping("weather")
    public Mono<CityWeatherResponseDto> getCityWeather(
            @RequestBody CityWeatherRequestDto cityWeatherRequestDto
    ) {
        logger.info("Received weather request: {}", cityWeatherRequestDto);
        return weatherService.getCityWeather(cityWeatherRequestDto);
    }

    @GetMapping("forecast")
    public Mono<String> getForecast(
            @RequestParam String city,
            @RequestParam(defaultValue = "metric") String unit,
            @RequestParam(defaultValue = "en") String lang) {
        return weatherService.getForecast(city, unit, lang);
    }
}
