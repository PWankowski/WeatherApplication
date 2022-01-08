package com.example.Client2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final RestTemplate restTemplate;

    public WeatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public Weather getWeather(){
        Config config = restTemplate.getForObject("http://config-service/config", Config.class);
        Weather weather = new Weather(10,config.getApiKey());
        return weather;
    }



}

class Config{
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}


class Weather {

    public int temp;
    public String apiKey;

    public Weather(int temp, String apiKey) {
        this.temp = temp;
        this.apiKey = apiKey;
    }

    public Weather() {
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
