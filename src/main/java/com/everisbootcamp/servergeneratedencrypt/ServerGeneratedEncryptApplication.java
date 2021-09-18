package com.everisbootcamp.servergeneratedencrypt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class ServerGeneratedEncryptApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerGeneratedEncryptApplication.class, args);
        log.info("SERVER LOGIC ENABLED");
    }
}
