package com.pelicula.pelicula.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vw_peliculas_completas")
public class PeliculaCompletavw {

    @Id
    private int id;

    private String titulo;

    @Column(name = "ano_lanzamiento")
    private Integer anoLanzamiento;

    private String directores;

    private String generos;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public String getDiretores() {
        return directores;
    }

    public String getGeneros() {
        return generos;
    }

    @Override
    public String toString() {
        return "PeliculaCompleta{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anoLanzamiento=" + anoLanzamiento +
                ", directores='" + directores + '\'' +
                ", generos='" + generos + '\'' +
                '}';
    }
}
