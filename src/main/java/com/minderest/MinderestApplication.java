package com.minderest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = { "com.minderest" })
@EnableAutoConfiguration
public class MinderestApplication {

    public static void main(String[] args) {
	SpringApplication.run(MinderestApplication.class, args);
    }

}
