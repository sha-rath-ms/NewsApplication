package com.example.newsApplicationDiscoveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NewsApplicationDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplicationDiscoveryServiceApplication.class, args);
	}

}
