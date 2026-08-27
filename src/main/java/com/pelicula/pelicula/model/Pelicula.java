/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pelicula.pelicula.model;

import jakarta.persistence.*;

/**
 *
 * @author kmanu
 */
@Entity
@Table(name = "pelicula")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 150) // Mapea 'varchar(150) NN'
    private String titulo;

    @Column(name = "genero", length = 50)
    private String genero;

    // En Java usamos camelCase, Spring lo traduce automáticamente a 'ano_lanzamiento'
    @Column(name = "ano_lanzamiento")
    private Integer anoLanzamiento;

    @Column(name = "director", length = 150)
    private String director;

    @Column(name = "estado")
    private Character estado = 'A';

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getAnoLanzamiento() {
        return anoLanzamiento;
    }

    public String getDirector() {
        return director;
    }

    public Character getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnoLanzamiento(Integer anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

}
