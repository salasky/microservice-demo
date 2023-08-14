package ru.salavat.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"ru.salavat","com.salavat"})
@EnableDiscoveryClient
@EntityScan(value = {"ru.salavat","com.salavat"})
public class AttorneyClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttorneyClientApplication.class, args);
    }

}
