package com.example.streamdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan(basePackages = "com.example")
@EnableWebMvc
@SpringBootApplication
public class StreamdemoApplication {


    @Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean( dispatcherServlet);
        registration.addUrlMappings("/api/*");
        return registration;
    }

    public static void main(String[] args) {
        SpringApplication.run(StreamdemoApplication.class, args);
    }
}
