package com.example.WheatherApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WheatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WheatherApplication.class, args);
	}

}
