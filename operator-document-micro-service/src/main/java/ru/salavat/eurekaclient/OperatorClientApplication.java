package ru.salavat.eurekaclient;

import com.salavat.dto.DocumentDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }, scanBasePackages = {"ru.salavat","com.salavat"})
@EnableDiscoveryClient
@EntityScan(value = {"ru.salavat","com.salavat"})
public class OperatorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OperatorClientApplication.class, args);

        for (int i = 0; i < 10; i++) {
            DocumentDTO documentDTO = new DocumentDTO();
            Random random = new Random();
            documentDTO.setContent(String.valueOf(random.nextLong()));
            documentDTO.setSignatureId(UUID.fromString("4868d938-57f8-42b8-8115-4bccaeb5b899"));
        }
    }

}
