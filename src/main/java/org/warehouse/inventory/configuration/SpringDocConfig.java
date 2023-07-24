package org.warehouse.inventory.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(
                new Info()
                        .title("By Aghazada Ramil")
                        .version("0.0.1")
                        .description("Project for inventory management")
                        .contact(
                                new Contact()
                                        .url("www.inventory.org")
                                        .email("aghazadaramil@gmail.com")
                                        .name("Aghazada Ramil")
                        )
        );
    }
}
