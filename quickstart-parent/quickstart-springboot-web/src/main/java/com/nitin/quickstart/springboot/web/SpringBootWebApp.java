package com.nitin.quickstart.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootWebApp 
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootWebApp.class, args);
    }
}
