/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pelicula.pelicula.model;

import jakarta.persistence.*;
import tools.jackson.databind.util.UniqueId;

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

    @Column(name = "titulo", nullable = false, length = 150, unique = true)
    private String titulo;

    // En Java usamos camelCase, Spring lo traduce automáticamente a 'ano_lanzamiento'
    @Column(name = "ano_lanzamiento")
    private Integer anoLanzamiento;

    @Column(name = "estado")
    private Character estado = 'A';

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAnoLanzamiento() {
        return anoLanzamiento;
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

    public void setAnoLanzamiento(Integer anoLanzamiento) {
        this.anoLanzamiento = anoLanzamiento;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

}
