package com.example.Client1;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ConfigService {


    public List<Config> getConfig(){

        Config openWeatherApiSource1 = new Config(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=baa6ece140be0985d8bf8766fa381d1d&units=metric",
                "openWeatherMap");
        Config openWeatherApiSource2 = new Config(
                "http://api.weatherstack.com/current?access_key=17ff09ba764b15dc96f5f8436421b30f&query=%s",
                "weatherStack");

        return Arrays.asList(openWeatherApiSource1,openWeatherApiSource2);

    }


}
