package com.example.Client2;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{name}")
    public WeatherEntity getWeather(@PathVariable String name){
      return weatherService.getWeather(name);
    }



}

class Config{

    private String url;
    private String serviceName;

    public Config(String url, String serviceName) {
        this.url = url;
        this.serviceName = serviceName;
    }

    public Config() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}


