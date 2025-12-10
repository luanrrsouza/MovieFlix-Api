package com.movieflix.movieflix.config;

import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {


        io.swagger.v3.oas.models.info.Contact contact = new io.swagger.v3.oas.models.info.Contact()
                .name("Luan")
                .email("luanrrdsouza@gmail.com")
                .url("https://devlpsouza.vercel.app/");



        io.swagger.v3.oas.models.info.Info info = new io.swagger.v3.oas.models.info.Info()
                .title("Movieflix API")
                .description("Documentação da API Movieflix para gerenciamento de filmes e usuários.")
                .version("v1.0.0")
                .contact(contact);



        return new OpenAPI().info(info);
    }
}