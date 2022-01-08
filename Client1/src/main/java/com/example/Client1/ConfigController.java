package com.example.Client1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {


    @GetMapping
    public Config getConfig(){
        return  new Config("test_api_key");
    }




}

class Config {

    private String apiKey;

    public Config(String apiKey) {
        this.apiKey = apiKey;
    }

    public Config() {
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
