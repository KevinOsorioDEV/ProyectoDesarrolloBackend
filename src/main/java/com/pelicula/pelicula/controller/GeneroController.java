package com.pelicula.pelicula.controller;

import com.pelicula.pelicula.model.Genero;
import com.pelicula.pelicula.repository.GeneroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/generos")
public class GeneroController {
    private static final Logger log = LoggerFactory.getLogger(PeliculaController.class);

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public List<Genero> obtenerGeneros() {
        log.info("Iniciando obtencion de generos {}", generoRepository.findAll());
        return generoRepository.findAll();
    }
}
