package ru.salavat.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = {"ru.salavat","com.salavat"})
@EnableDiscoveryClient
@EntityScan(value = {"ru.salavat","com.salavat"})
@RefreshScope
public class OperatorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatorClientApplication.class, args);
    }

}
