package com.pelicula.pelicula.repository;

import com.pelicula.pelicula.model.PeliculaCompletavw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaCompletaRepository extends JpaRepository<PeliculaCompletavw, Integer> {
}
