package com.http418;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by pedro on 2/6/18.
 */

@SpringBootApplication
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class KeycloakSecurityExemplo extends SpringBootServletInitializer{

      // metodo necessario para deploy em outros servidores de aplicoes
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(KeycloakSecurityExemplo.class);
    }


    public static void main(String[] args){
        SpringApplication.run(KeycloakSecurityExemplo.class, args);
    }
}
