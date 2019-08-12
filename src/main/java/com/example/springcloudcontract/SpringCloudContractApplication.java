package com.example.springcloudcontract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringCloudContractApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudContractApplication.class, args);
    }

}
