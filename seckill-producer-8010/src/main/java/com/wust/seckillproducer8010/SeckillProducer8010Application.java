package com.wust.seckillproducer8010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SeckillProducer8010Application {

    public static void main(String[] args) {
        SpringApplication.run(SeckillProducer8010Application.class, args);
    }

}
