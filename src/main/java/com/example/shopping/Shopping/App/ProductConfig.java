package com.example.shopping.Shopping.App;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductConfig {


    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {

            Product phone = new Product(
                    "iPhone 14",
                    new BigDecimal("2000"),
                    "iOS",
                    "This is iPhone 14"
            );
            Product phone1 = new Product(
                    "iPhone 12",
                    new BigDecimal("900"),
                    "iOS",
                    "This is iPhone 12"
            );
            Product phone2 = new Product(
                    "Techno Camon 20",
                    new BigDecimal("400"),
                    "Android",
                    "Brand New Techno Camon Series"
            );

            Product phone3 = new Product(
                    "SamSung A20",
                    new BigDecimal("234.55"),
                    "Android",
                    "Samsung Latest"
            );

            productRepository.saveAll(List.of(phone, phone1, phone2, phone3));

        };
    }


}
