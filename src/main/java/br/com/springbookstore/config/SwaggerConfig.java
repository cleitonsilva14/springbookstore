package br.com.springbookstore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring Boot API")
                                .description("API REST Spring Boot")
                                .version("1.0.0")
                                .license(
                                        new License().name("").url("")
                                )
                                .contact(
                                        new Contact().name("")
                                )
                );
    }

}
