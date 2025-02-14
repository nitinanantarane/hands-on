package com.nitin.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootWebApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootWebApp.class, args);
    }
}
