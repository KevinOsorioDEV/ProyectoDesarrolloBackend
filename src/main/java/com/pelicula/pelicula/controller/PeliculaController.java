/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pelicula.pelicula.controller;

import com.pelicula.pelicula.model.Pelicula;
import com.pelicula.pelicula.repository.PeliculaRepository;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author kmanu
 */
@RestController
@RequestMapping("api/peliculas")
public class PeliculaController {

    private static final Logger log = LoggerFactory.getLogger(PeliculaController.class);

    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping
    public List<Pelicula> obtenerTodas() {

        log.info("-> obtenerTodas() // obteniendo todas las peliculas");
        return peliculaRepository.findAll();
    }
    
    @PostMapping
    public Pelicula guardarPelicula(@RequestBody Pelicula nuevaPelicula){
        log.info("-> Guardando una nueva película: {}, {},{},{}", nuevaPelicula.getId(), nuevaPelicula.getTitulo(), nuevaPelicula.getDirector(),nuevaPelicula.getAnoLanzamiento());
        return peliculaRepository.save(nuevaPelicula);
    }

    @PatchMapping("/{titulo}/estado")
    public Pelicula actualizarPelicula(@PathVariable String titulo, @RequestBody Pelicula actualizaciones) {
        Optional<Pelicula> peliculaOptional = peliculaRepository.findByTitulo(titulo);
        if (peliculaOptional.isPresent()) {
            Pelicula peliculaExistente = peliculaOptional.get();

            peliculaExistente.setEstado(actualizaciones.getEstado());

            return peliculaRepository.save(peliculaExistente);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelicula no encontrada "+titulo);
        }
    }
}
