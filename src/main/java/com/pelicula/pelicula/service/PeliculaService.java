package com.pelicula.pelicula.service;

import com.pelicula.pelicula.config.RabbitMQConfig;
import com.pelicula.pelicula.model.Pelicula;
import com.pelicula.pelicula.repository.PeliculaRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class PeliculaService {

    private static final Logger logger = LoggerFactory.getLogger(PeliculaService.class);

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional
    public Pelicula crearPelicula(Pelicula pelicula) {
        Pelicula peliculaGuardada = peliculaRepository.save(pelicula);
        try {
            String mensajejson = objectMapper.writeValueAsString(peliculaGuardada);
            rabbitTemplate.convertAndSend(RabbitMQConfig.COLA_PELICULAS, mensajejson);
            logger.info("Evento enviado a RabbitMQ para la película: {}", peliculaGuardada.getTitulo());
        }catch (Exception e) {
            logger.error("Error enviando el evento a RabbitMQ de la película: {}", peliculaGuardada.getTitulo(), e);
        }
        return peliculaGuardada;
    }



}
