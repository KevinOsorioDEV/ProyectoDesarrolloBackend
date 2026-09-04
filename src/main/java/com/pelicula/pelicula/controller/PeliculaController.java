/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pelicula.pelicula.controller;

import com.pelicula.pelicula.model.Pelicula;
import com.pelicula.pelicula.model.PeliculaCompletavw;
import com.pelicula.pelicula.repository.PeliculaCompletaRepository;
import com.pelicula.pelicula.repository.PeliculaRepository;
import java.util.List;
import java.util.Optional;


import com.pelicula.pelicula.service.PeliculaService;
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

    @Autowired
    private PeliculaCompletaRepository peliculaCompletaRepository;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> obtenerTodas() {

        log.info("-> obtenerTodas() // obteniendo todas las peliculas");
        return peliculaRepository.findAll();
    }
    
    @PostMapping
    public Pelicula guardarPelicula(@RequestBody Pelicula nuevaPelicula){
        log.info("-> Guardando una nueva película: {}, {},{}", nuevaPelicula.getId(), nuevaPelicula.getTitulo(),nuevaPelicula.getAnoLanzamiento());
        return peliculaService.crearPelicula(nuevaPelicula);
    }
    //Actualizar estado peliculas
    @PatchMapping("/{titulo}/estado")
    public Pelicula actualizarPelicula(@PathVariable String titulo, @RequestBody Pelicula actualizaciones) {
        Optional<Pelicula> peliculaOptional = peliculaRepository.findByTitulo(titulo);
        log.info("-> Intentando actualizar el estado de la película con título: {}", titulo);
        if (peliculaOptional.isPresent()) {
            Pelicula peliculaExistente = peliculaOptional.get();

            peliculaExistente.setEstado(actualizaciones.getEstado());
            log.info("-> ¡Éxito! Estado actualizado a '{}' para la película: {} - {}", actualizaciones.getEstado(), peliculaExistente.getId(),titulo);
            return peliculaRepository.save(peliculaExistente);
        }else {
            log.warn("-> No se encontró ninguna pelicula con el titulo {}", titulo);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelicula no encontrada "+titulo);
        }
    }

    @GetMapping("/completas")
    public List<PeliculaCompletavw> obtenerPeliculasCompletas() {
        log.info("Vista a ejecutar : vw_peliculas_completas");
        List<PeliculaCompletavw> resultado = peliculaCompletaRepository.findAll();
        log.info("Se encontraron {} resultado en la vista, datos {}", resultado.size(), resultado);
        return resultado;
    }
}
