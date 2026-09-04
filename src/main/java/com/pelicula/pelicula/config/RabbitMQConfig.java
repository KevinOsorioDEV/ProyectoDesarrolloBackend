package com.pelicula.pelicula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

        public static final String COLA_PELICULAS = "peliculas_cola";

        @Bean
        public Queue queue() {
            return new Queue(COLA_PELICULAS,true);
        }

}
