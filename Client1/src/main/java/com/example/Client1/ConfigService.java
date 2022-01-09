package com.example.Client1;

import org.springframework.stereotype.Service;

@Service
public class ConfigService {


    public Config getConfig(){
       return  new Config("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=baa6ece140be0985d8bf8766fa381d1d&units=metric","openweatherMap");

    }


}
