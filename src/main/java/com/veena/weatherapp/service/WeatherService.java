package com.veena.weatherapp.service;
import com.veena.weatherapp.dto.CityWeatherResponseDto;
import com.veena.weatherapp.exception.WeatherException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {
    private final WebClient webClient;

    @Value("${openweather.api.key}")
    private String apiKey;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public Mono<CityWeatherResponseDto> getCityWeather(String city, String unit, String lang) {
        String url = "/weather?q=" + city + "&appid=" + apiKey + "&units=" + unit + "&lang=" + lang;

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Map.class)
                .map(this::mapToCityWeatherResponseDto);
    }

    private CityWeatherResponseDto mapToCityWeatherResponseDto(Map<String, Object> response) {
        String cityName = (String) response.get("name");

        Map<String, Object> main = (Map<String, Object>) response.get("main");
        Double temperature = main != null ? ((Number) main.get("temp")).doubleValue() : null;
        Double humidity = main != null ? ((Number) main.get("humidity")).doubleValue() : null;
        Double pressure = main != null ? ((Number) main.get("pressure")).doubleValue() : null;

        Map<String, Object> wind = (Map<String, Object>) response.get("wind");
        Double windSpeed = wind != null ? ((Number) wind.get("speed")).doubleValue() : null;

        List<Map<String, Object>> weatherList = (List<Map<String, Object>>) response.get("weather");
        String description = (weatherList != null && !weatherList.isEmpty()) ?
                (String) weatherList.get(0).get("description") : null;

        CityWeatherResponseDto weatherResponse = new CityWeatherResponseDto();
        weatherResponse.setCityName(cityName);
        weatherResponse.setDescription(description);
        weatherResponse.setHumidity(humidity);
        weatherResponse.setPressure(pressure);
        weatherResponse.setTemperature(temperature);
        weatherResponse.setWindSpeed(windSpeed);
        return weatherResponse;
    }

    public Mono<String> getForecast(String city, String unit, String lang) {
        String url = "/forecast?q=" + city + "&appid=" + apiKey + "&units=" + unit + "&lang=" + lang;
        return webClient.get().uri(url).retrieve().bodyToMono(String.class);
    }

}
