package com.example.toyboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value="file:${TOY_HOME}/application.yml")
@SpringBootApplication
public class ToyBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToyBoardApplication.class, args);
    }

}
