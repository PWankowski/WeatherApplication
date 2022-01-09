package com.example.Client2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {


    private final RestTemplate microserviceClient;
    private final RestTemplate httpClient;

    public WeatherService(@Qualifier("microservice") RestTemplate microserviceClient,
                          @Qualifier("http") RestTemplate httpClient) {
        this.microserviceClient = microserviceClient;
        this.httpClient = httpClient;
    }

    public WeatherEntity getWeather(String name){

        Config config = microserviceClient.getForObject("http://config-service/config", Config.class);
        OpenWeather openWeather = httpClient.getForObject(String.format(config.getUrl(),name),OpenWeather.class);
        WeatherEntity weather = new WeatherEntity();
        weather.setServiceName(config.getServiceName());
        weather.setTemperature(openWeather.getMain().getTemp());
        weather.setPressure(openWeather.getMain().getPressure());
        weather.setHumidity(openWeather.getMain().getHumidity());

        return weather;

    }

}
