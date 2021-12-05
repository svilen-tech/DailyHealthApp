package com.example.dailyhealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DailyHealthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DailyHealthApplication.class, args);

    }

}
