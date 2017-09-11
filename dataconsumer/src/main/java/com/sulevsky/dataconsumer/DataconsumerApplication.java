package com.sulevsky.dataconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DataconsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataconsumerApplication.class, args);
    }
}
