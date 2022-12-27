package com.example.Client1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConfigService {


    public List<Config> getConfig(){

        Config openWeatherApiSource1 = new Config(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=4a2a3b81d4817483a66f50afe4ca3757&units=metric",
                "openWeatherMap");
        Config openWeatherApiSource2 = new Config(
                "http://api.weatherstack.com/current?access_key=4e804229182e92fe0f3b529babf9eec8&query=%s",
                "weatherStack");

        return Arrays.asList(openWeatherApiSource1,openWeatherApiSource2);

    }


}
