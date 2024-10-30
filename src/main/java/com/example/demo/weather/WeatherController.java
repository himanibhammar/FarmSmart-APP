package com.example.demo.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class WeatherController {
	
	//Mapping for Weather API
	@GetMapping("/getWeather")
    public Weather getWeather(@RequestParam("city") String city) {
				
        String apiKey = "43b16e750aa6bdf9f9e144aa09962ea4";
        
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
        
        String url = String.format("%s?q=%s&units=metric&appid=%s", apiUrl, city, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        Weather weather = restTemplate.getForObject(url, Weather.class);

        return weather;
    }

}