package com.veena.weatherapp.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityWeatherRequestDto {
    @NotBlank(message = "City name is required")
    private String cityName;
    private String unit;
    private String language;
}
