package com.example.NewsApplicationAccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NewsApplicationAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplicationAccountApplication.class, args);
	}

}
