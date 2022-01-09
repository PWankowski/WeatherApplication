package com.example.Client2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {


    private final RestTemplate microserviceClient;
    private final RestTemplate httpClient;

    public WeatherService(@Qualifier("microservice") RestTemplate microserviceClient,
                          @Qualifier("http") RestTemplate httpClient) {
        this.microserviceClient = microserviceClient;
        this.httpClient = httpClient;
    }

    public List<WeatherEntity> getWeather(String name){

        Config[] config = microserviceClient.getForObject("http://config-service/config", Config[].class);

        return Arrays.stream(config)
                .map(c -> {
                    WeatherEntity weather = new WeatherEntity();
                    switch (c.getServiceName()){
                        case "openWeatherMap":
                            OpenWeather openWeather = httpClient.getForObject(String.format(c.getUrl(),name),OpenWeather.class);
                            weather.setServiceName(c.getServiceName());
                            weather.setTemperature(openWeather.getMain().getTemp());
                            weather.setPressure(openWeather.getMain().getPressure());
                            weather.setHumidity(openWeather.getMain().getHumidity());
                            break;
                        case "weatherStack":
                            WeatherStack weatherStack = httpClient.getForObject(String.format(c.getUrl(),name),WeatherStack.class);
                            weather.setServiceName(c.getServiceName());
                            weather.setTemperature(weatherStack.getCurrent().getTemperature());
                            weather.setPressure(weatherStack.getCurrent().getPressure());
                            weather.setHumidity(weatherStack.getCurrent().getHumidity());
                            break;
                    }
                    return weather;
                } ).collect(Collectors.toList());
    }

}
