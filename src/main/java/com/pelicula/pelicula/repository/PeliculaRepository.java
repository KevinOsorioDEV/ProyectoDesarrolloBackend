/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pelicula.pelicula.repository;

import com.pelicula.pelicula.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author kmanu
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

    //viene siendo un select * from pelicula where titulo = ?
    Optional<Pelicula> findByTitulo(String titulo);
}
