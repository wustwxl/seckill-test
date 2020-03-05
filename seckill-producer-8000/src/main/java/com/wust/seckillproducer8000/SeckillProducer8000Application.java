package com.wust.seckillproducer8000;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SeckillProducer8000Application {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProducer8000Application.class, args);
    }

}
