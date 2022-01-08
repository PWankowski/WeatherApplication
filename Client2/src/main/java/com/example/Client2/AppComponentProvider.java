package com.example.Client2;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppComponentProvider {

    @Bean
    @LoadBalanced
    public RestTemplate microserviceClient(){
        return new RestTemplate();
    }


}
