package com.veena.weatherapp.service;
import com.veena.weatherapp.dto.CityWeatherRequestDto;
import com.veena.weatherapp.dto.CityWeatherResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {
    private final WebClient webClient;

    private final String apiKey;
    private final String apiUrl;

    public WeatherService(WebClient.Builder webClientBuilder) {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("OPEN_WEATHER_API_KEY");
        this.apiUrl = dotenv.get("OPEN_WEATHER_API");
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public Mono<CityWeatherResponseDto> getCityWeather(CityWeatherRequestDto requestDto) {
        String url = "/weather?q=" + requestDto.getCityName()
                + "&units=" + requestDto.getUnit()
                + "&lang=" + requestDto.getLanguage()
                + "&appid=" + "dd0eb40220a5a30e10fd7323dc14ce3b";

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(Map.class)
                .map(this::mapToCityWeatherResponseDto);
    }

    private CityWeatherResponseDto mapToCityWeatherResponseDto(Map<String, Object> response) {
        String cityName = (String) response.get("name");

        Map<String, Object> coords = (Map<String, Object>) response.get("coord");
        Double latitude = coords != null ? ((Number) coords.get("lat")).doubleValue() : null;
        Double longitude = coords != null ? ((Number) coords.get("lon")).doubleValue() : null;

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
        weatherResponse.setLatitude(latitude);
        weatherResponse.setLongitude(longitude);
        return weatherResponse;
    }

}
